package com.worden.pipelines.reader.collection;

import java.io.InputStream;
import java.io.Serializable;

public class ExtractedBook implements Serializable {
    private int bookId;
    private String url;
    private InputStream inputStream;
}
