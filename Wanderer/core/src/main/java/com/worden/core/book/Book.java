package com.worden.core.book;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "of")
public class Book {

    private int bookId;
    private String url;
}
