package com.worden.source;

import org.apache.beam.sdk.values.PBegin;
import org.apache.beam.sdk.values.PCollection;

public interface SourceStep<T> {

    T collectData(PBegin pBegin);

}
