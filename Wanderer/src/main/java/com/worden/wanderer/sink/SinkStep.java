package com.worden.sink;

import org.apache.beam.sdk.values.PDone;

public interface SinkStep<T> {

    PDone populateData(T data);

}
