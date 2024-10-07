package com.worden.wanderer.source;

import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.values.PBegin;

import org.apache.beam.sdk.values.POutput;
import org.jetbrains.annotations.NotNull;

public abstract class SourceTransform<Output extends POutput>
        extends PTransform<PBegin, Output>
        implements SourceStep<Output> {

    @NotNull
    @Override
    public Output expand(@NotNull PBegin input) {
        return collectData(input);
    }
}
