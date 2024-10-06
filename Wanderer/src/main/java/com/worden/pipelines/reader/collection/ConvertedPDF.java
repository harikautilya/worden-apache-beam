package com.worden.pipelines.reader.collection;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.Serializable;

public class ConvertedPDF implements Serializable {
    private int bookId;
    private PDDocument document;
}
