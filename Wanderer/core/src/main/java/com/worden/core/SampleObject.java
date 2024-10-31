package com.worden.core;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true, setterPrefix = "of")
public class SampleObject {
    private int priitiveInt;
    private NestedObject nestedObject;

    @Getter
    @Builder(toBuilder = true, setterPrefix = "of")
    public static class NestedObject {
        int nestedObjInt;
    }


    public SampleObject recreate(){
        return this.toBuilder()
                .ofNestedObject(this.getNestedObject().toBuilder().build())
                .build();

    }
}
