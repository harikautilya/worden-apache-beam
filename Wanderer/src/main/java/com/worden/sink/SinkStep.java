package com.worden.sink;

import org.apache.beam.sdk.values.PCollection;

public interface SinkStep<T> {

    boolean populateData(PCollection<T> data);

}
