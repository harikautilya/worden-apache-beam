package com.worden.processor;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;

public class ProcessorPipeline {

    public static void main(String[] args) {
        ProcessorOptions options = PipelineOptionsFactory.fromArgs(args)
                .withValidation()
                .as(ProcessorOptions.class);
                
        Pipeline pipeline = Pipeline.create(options);
        
        pipeline.apply("Create value", Create.of("Sample", "Sample2"))
        .apply("Test",  ParDo.of(new DoFn<String,String>() {
            
            @ProcessElement
            public void processElement(ProcessContext context){
               System.out.println(context.element());
               context.output(context.element());
            }

        }));

        pipeline.run().waitUntilFinish();
    }
}
