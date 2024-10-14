package com.worden.common;

import java.io.Serializable;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "of")
class ReadBook implements Serializable {

    private Long id;
    private String bookUrl;
}
