package com.worden.core.extract.impl;

import java.io.InputStream;
import java.util.List;

import com.worden.core.extract.ExtractedText;

public class PDFExtractionDao implements ExtractionDao {

    @Override
    public List<ExtractedText> extractText(InputStream inputStream) {
        return List.of();
    }
}
