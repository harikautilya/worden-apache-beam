package com.worden.extract.impl;

import com.worden.extract.ExtractedText;

import java.io.InputStream;
import java.util.List;

public interface ExtractionDao {

     List<ExtractedText> extractText(InputStream inputStream);
}
