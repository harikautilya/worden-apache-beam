package com.worden.sink;

import org.apache.beam.sdk.transforms.PTransform;

import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PDone;
import org.jetbrains.annotations.NotNull;

public abstract class SinkTransform<Input extends PCollection<?>>
        extends PTransform<Input, PDone>
        implements SinkStep<Input> {

    @NotNull
    @Override
    public PDone expand(@NotNull Input input) {
        return populateData(input);
    }
}
