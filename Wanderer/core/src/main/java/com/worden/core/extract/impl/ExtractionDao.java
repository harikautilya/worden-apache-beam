package com.worden.core.extract.impl;

import java.io.InputStream;
import java.util.List;

import com.worden.core.extract.ExtractedText;

public interface ExtractionDao {

    List<ExtractedText> extractText(InputStream inputStream);
}
