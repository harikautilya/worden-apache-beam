package com.worden.book;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "of")
public class Book {
    private int bookId;
    private String url;
}
