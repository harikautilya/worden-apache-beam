# SRS Wanderer

## Overview
As part of the PRD one of the step is to read from books and convert to  text. The text has to filtered out to be remove
articles, the text later will bed attached scores based on the length of the word and forward to other sinks.
Each page of the book will have a page score with respect how many even length words are present , if and when such words
are same total word count will be present and if when total words match , page number will be considered for the purpose
of scoring.

The scoring mechanisms is not planned to be decoupled as the scope of different types of scoring is not clear at this instant.

## Functional
- Only PDF books are to be accepted for processing.
- The pdf books are to be present as a single http/https link per book.
- All the books are expected to be in english

## Non-Functional
- Able to understand the time take to process each book
- The book is expected to be processed in less than half an hour (< 30 mins)
- The expected load is based on the revenue goal
    - Each user max income potential : (0.01 + (0.001*10000)) * 100 = 1001 dollars
    - 1mil/ 1001 = 999.000999 ~ 1000 such users per month
    - 1000/30 ~ 34 such books per day
    - Since each book may not have 10000 page , a more real world approach would be to consider ~1000 page per book
    - 1mil/(((0.01 + (0.001*1000)) * 100)*30) ~ 331 per day


## Risk
## Capacity Planning

# System Design Wanderer
One of the key aspect when reading and processing
file is that some of the file do range at different size and different format. Some good examples could highly textual books
such as biographies, programming languages books, novels etc and some of the books can highly illustration driven such as graphic
novel, brochure etc. To ensure that system is able to accept file of different size and to ensure to have ability to add
more format in the future. Wanderer is the data processing pipeline project part of the Z project.  The project will take advantage of apache beam
which is open source data processing pipeline design for parallel compute. Dataflow will be used as part of the runner to
take advantage of the cloud offering of Google.

- A cloud function will read the file in bucket and prepare a signed storage url
- The pre-generated urls will be pushed to pubsub topic
- The pipeline will read data from pub-sub topic and process the pdf file
- The generated text will be pushed to google firestore


## Resources
- https://cloud.google.com/storage/docs/access-control/signed-urls
- https://firebase.google.com/docs/firestore