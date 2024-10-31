package com.worden;

import com.worden.core.SampleObject;

public class MainExec {

    public static void main(String[] args) {

        // Run time object
        SampleObject sample = SampleObject.builder()
                .ofPriitiveInt(-2)
                .ofNestedObject(
                        SampleObject.NestedObject.builder()
                                .ofNestedObjInt(-1)
                                .build()
                ).build();


        // This recreates the entire object
        sample.recreate()

    }
}
