package com.worden.core.extract;

import java.io.InputStream;
import java.util.List;

import com.worden.core.extract.impl.ExtractionDao;

public class ExtractionService {

    private final ExtractionDao extractionDao;

    public ExtractionService(ExtractionDao extractionDao) {
        this.extractionDao = extractionDao;
    }

    List<ExtractedText> extractText(InputStream inputStream) {
        return extractionDao.extractText(inputStream);
    }
}
