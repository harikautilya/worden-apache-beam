package com.worden.wanderer.pipelines.processor;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptionsFactory;

public class ProcessorPipeline {

    public static void main(String[] args) {
        Options options = PipelineOptionsFactory.fromArgs(args)
                .withValidation()
                .as(Options.class);

        Pipeline pipeline = Pipeline.create(options);

        pipeline.run().waitUntilFinish();
    }
}
