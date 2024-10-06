

# System Design Wanderer

## Overview
One of the key aspect when reading and processing file is that some of the files do range at different size and different
format. Some good examples could highly textual books such as biographies, programming languages books, novels, etc. and
some of the books can be highly illustration driven such as graphic novel, brochure etc. To ensure that system is able to
accept file of different size and to ensure to have ability to add more format in the future, a data pipeline processing
will be developed instead of a microservice. This will ensure that the pipeline can be scaled for different needs in terms
of file sizes and file formats. `Wanderer` is the data processing pipeline project part of the Z project. The project will
take advantage of apache beam which is open source data processing pipeline design for parallel compute. Dataflow will be
used as part of the runner to take advantage of the cloud offering of Google.

## Solution
Two separate pipelines will be developed, where one pipeline `Reader` will be used to read the book from a given url to
plain text page wise and another pipeline `Processor` will be used to collect the text and score it and store the
information into the sinks. This will provide the following advantages

1. Separation of concerns to mitigate risk of time processing so each individual pipeline will be a scale independently
2. `Processor` input will always be a text, as long the input remains the same the system can be used for other revenue
   steams in the future such as paragraph processing
3. Reading a file and converting to text is a heavy process, we dont want to repeat in case anything goes wrong during scoring

### Reader Pipeline design

#### Business logic
The `Reader` will read input from a pub-sub where the pub-sub topic holds information regarding the book and the url to
read the file from. The url will be read as input stream to store the information in the in-memory of the pipeline. The
input steam will be read and converted to a `PDDocument`. The document will be read page wise and the text will be populated
to a no sql database linking the book id and page number for each extracted text.

Below lies a sample snippet to facilitate above solution and validate if such use-case is possible.

```java
public class Main {
  public static void main(String[] args) throws IOException {
    URL url=new URL("https://www.allthingsdistributed.com/files/amazon-dynamo-sosp2007.pdf");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    BufferedInputStream bufferedInputStream = new BufferedInputStream(connection.getInputStream());
    PDDocument document = Loader.loadPDF(new RandomAccessReadBuffer(bufferedInputStream));
    System.out.println("Document loaded");
    PDFTextStripper stripper = new PDFTextStripper();
    int pagesToExtract = 2;
    for (int i = 0; i <= pagesToExtract; i++) {
      int page = i;
      stripper.setStartPage(page);
      stripper.setEndPage(page);
      String text = stripper.getText(document);
      System.out.println(text);
    }
    document.close();
  }
}
```

#### Pub-sub topic Source
A pub-sub topic `dataflow_read_book` should hold the following information apart from any other information the message
may contain. The pipeline will not read the rest of the json.  The url of book will always be a cloud storage bucket
url but not a open world internet url. This ensures that the availability of the url is not dependent on the user but
the reliability will be on the service. This will ensure that the pipeline can restart if and when the job fails due
to any reason.

```json
{
  "book_id": 1,
  "book_url": "https://storage.apis...............",
  "produced_at": "06-10-2024 12:00:00" 
}
```
`produced_at` refers the timestamp at which the event is produced, This will help in analysis the time taken for the pipeline
to pick up the event to start processing.

#### Fire-store Sink
After the book is processed, the page text will be stored at no-sql storage. A nosql storage is chosen as we are not looking for
highly related database to support multiple feature. Any key-value data storage solution would work, to take advantage of
gcp offering firestore will be used here. This will act as sink for this pipeline.

The key `reader` will hold the following structure per page

<table>
<tr>
<th>
Key
</th>
<th>
Value
</th>
</tr>
<tr>
<td>
  book_id:page_number
</td>
<td>
<pre>
  {
  "book_id": 1,
  "text" : ".....................",
  "page_number" : 1,
  "produced_at": "06-10-2024 12:00:00",
  "processed_at": "06-10-2024 12:01:00"
  }
</pre>
</td>
</tr>
</table>


#### Pipeline Design
This pipeline will be streaming pipeline as to facilitate no delay in start of the processing if when user requests a
book to be processed. A windowing strategy if fixed time of 1 minute will be used to group the message and process the
book. After reading the text from a book, all the text will be push to fire-store along with page and book information

The following `Dag` will be developed addressing the above logical understanding and having `unbounded` PCollection

![img.png](assets/img.png)
Steps:
1. The pipeline starts by reading message from pubsub and then creates a PCollection of `EBook` that contains information about
   book id and book url.
2. The Ebook PCollection will be input to the `StreamConvertor` that take the Ebook and converts it into input stream, this
   updates the EBook input stream field as well of the PCollection
3. The updated Ebook PCollection will be sent to PrepareDocument, which prepare document `CPDF`. The object holds PDDocument
   and book id
4. The PCollection `CPDF` will be sent to collect page text and PCollect of `EText` will be created. The `EText` will hold
   information about book id and list of page wise text
5. The PCollection `EText` will then be forwarded to Publish , which is the sink of the application.


### Processor Pipeline Design

`Before reading this please check note in the repo Readme at `[Here](Readme.md)

The `Processor` pipeline will run every 5 mins which is scheduled using the cloud scheduler. The pipeline will read data
from `reader` key in the fire-store. After reading data from fire-store , each page will be converted into list of words.
The words will be processed to calculate word count, even word length words and odd word length words to process. The final
score will be calculated as follows

```
word_count X odd_word_length_count X even_word_length_count X page_number
```
As the page information is no longer needed post scoring. Post calculation the data in the fire-store will be
deleted page-wise to ensure that costing is saved. Scores will push to pub-sub topic


#### Pub-sub topic Sink
The data will be pushed to pubsub topic `dataflow_processed_book`. The message structure will be following

```json
{
  "book_id": 1,
  "word_count" : 1,
  "odd_word_length_count": 1,
  "even_word_length_count" : 1,
  "page_number" : 1,
  "final_score" : 1.0
}
```

#### Pipeline Design

The pipeline will be batch mode as to facilate the use of bulk processing and on the account on being a heavy compute operation.
A batch size of 10 pages to take advantage of parallel processing.

The following `Dag` will be developed addressing the above logical understanding and having `bounded` PCollection

![img.png](assets/img_1.png)

Steps:
1. The pipeline starts with no input and collects data from fire-store and a PCollection of `PPage` is prepared. `PPage` holds
   information about book_id and text from a single page
2. The page text will be split into words and `PWords` is prepared. `PWords` hold information about book_id, Map of words,
   integer to hold odd_word_length_count, even_word_length_count, word_count
3. 2 Parallel step are computed per page
    1. One step gets length of each word and populated to the map
        1. After receiving map number of odd length words is calculated and `PWord` is updated
        2. After receiving map number of even length words is calculated and `PWord` is updated
    2. Another step to calculate word count.
3. All the `PWords` is accumulated and forwarded to publish
4. The publishing step will publish it to pub-sub



## Release
- Standard release practice of the organization

## Test plan

### Functional Testing
- A single 100-page PDF will be uploaded to test the basic functionality
- A single 10000-page PDF will be uploaded to stress test

### Load Testing
`Ideally i would run this but we can't run the full load test as it would be charged to me. :(`

- Around 100 books which is 1/3 of the expected load per day will be populated to load test
- Around 200 books which is 2/3 of the expected load per day will be populated to load test
- Around 300 books which is all the expected load per day will be populated to load test
- Around 300 books which is exceeded the expected load per day will be populated to load test to test high demand time

## Resources
- https://firebase.google.com/docs/firestore
- https://cloud.google.com/pubsub/docs/stream-messages-dataflow


---------------------
---------------------