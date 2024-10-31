package com.worden.processor;

import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.Validation;

public interface ProcessorOptions extends PipelineOptions {

    @Validation.Required

}
