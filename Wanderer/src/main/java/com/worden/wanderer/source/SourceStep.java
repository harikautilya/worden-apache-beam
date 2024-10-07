package com.worden.wanderer.source;

import org.apache.beam.sdk.values.PBegin;

public interface SourceStep<T> {

    T collectData(PBegin pBegin);

}
