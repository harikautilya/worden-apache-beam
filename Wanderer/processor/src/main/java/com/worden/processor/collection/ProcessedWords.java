package com.worden.processor.collection;

import java.io.Serializable;
import java.util.Map;

public class ProcessedWords implements Serializable {

    private int bookId;
    private Map<String, Integer> words;
    private int wordCount;
    private int oddWordLengthCount;
    private int evenWordLengthCount;
    private int pageNumber;
}
