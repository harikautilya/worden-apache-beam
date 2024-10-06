package com.worden.extract.impl;

import com.worden.extract.ExtractedText;

import java.io.InputStream;
import java.util.List;

public class PDFExtractionDao implements ExtractionDao{
    @Override
    public List<ExtractedText> extractText(InputStream inputStream) {
        return List.of();
    }
}
