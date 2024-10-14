package com.worden.reader;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptionsFactory;

import com.worden.common.BookIO;
import com.worden.core.book.BookService;

public class ReaderPipeline {

    public static void main(String[] args) {

        // This will expose the options as part of the args for help section etc
        PipelineOptionsFactory.register(ReaderOptions.class);

        // Pipeline options
        ReaderOptions options = PipelineOptionsFactory.fromArgs(args)
                .withValidation()
                .as(ReaderOptions.class);

        // Service classes
        BookService service = options.getBookService();

        // Create pipeline 
        Pipeline pipeline = Pipeline.create(options);

        // Prepare pipeline
        pipeline.apply(BookIO.collectBook(service));

        // Run Pipeline
        pipeline.run().waitUntilFinish();
    }

}
