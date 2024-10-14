package com.worden.reader.collection;

import java.io.Serializable;

import org.apache.pdfbox.pdmodel.PDDocument;

public class ConvertedPDF implements Serializable {

    private int bookId;
    private PDDocument document;
}
