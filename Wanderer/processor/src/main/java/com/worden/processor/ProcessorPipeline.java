package com.worden.processor;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptionsFactory;

public class ProcessorPipeline {

    public static void main(String[] args) {
        ProcessorOptions options = PipelineOptionsFactory.fromArgs(args)
                .withValidation()
                .as(ProcessorOptions.class);

        Pipeline pipeline = Pipeline.create(options);

        pipeline.run().waitUntilFinish();
    }
}
