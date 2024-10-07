package com.worden.wanderer.pipelines.processor.collection;

import java.io.Serializable;

public class ProcessedPage implements Serializable {

    private int bookId;
    private String pageText;
    private int pageNumber;
}
