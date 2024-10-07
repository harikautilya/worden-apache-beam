package com.worden.wanderer.pipelines.reader;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptionsFactory;

public class ReaderPipeline {

    public static void main(String[] args) {

        Options options = PipelineOptionsFactory.fromArgs(args)
                .withValidation()
                .as(Options.class);

        Pipeline pipeline = Pipeline.create(options);
        preparePipeline(pipeline);
        pipeline.run().waitUntilFinish();
    }

    private static void preparePipeline(Pipeline pipeline) {

    }
}
