package com.worden.reader;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;


/**
 * Pipeline class for the DAG.
 */
public class ReaderPipeline {

    public static void main(String[] args) {

        // This will expose the options as part of the args for help section etc
        PipelineOptionsFactory.register(ReaderOptions.class);

        // Pipeline options
        ReaderOptions options = PipelineOptionsFactory.fromArgs(args)
                .withValidation()
                .as(ReaderOptions.class);

        // Create pipeline 
        Pipeline pipeline = Pipeline.create(options);

        // Test pipeline
        pipeline.apply("Create value", Create.of("Sample", "Sample2"))
        .apply("Test",  ParDo.of(new DoFn<String,String>() {
            
            @ProcessElement
            public void processElement(ProcessContext context){
               System.out.println(context.element());
               context.output(context.element());
            }

        }));

        // Run Pipeline
        pipeline.run().waitUntilFinish();
    }

}
