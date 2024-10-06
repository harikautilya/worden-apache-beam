package com.worden.source;

import org.apache.beam.sdk.values.PCollection;

public interface SourceStep<T> {

    PCollection<T> collectData();

}
