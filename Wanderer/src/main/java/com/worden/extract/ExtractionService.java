package com.worden.extract;

import com.worden.extract.impl.ExtractionDao;

import java.io.InputStream;
import java.util.List;

public class ExtractionService {

    private final ExtractionDao extractionDao;

    public ExtractionService(ExtractionDao extractionDao) {
        this.extractionDao = extractionDao;
    }

    List<ExtractedText> extractText(InputStream inputStream){
        return extractionDao.extractText(inputStream);
    }
}
