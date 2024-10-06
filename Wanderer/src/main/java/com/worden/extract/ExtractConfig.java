package com.worden.extract;

import com.worden.extract.impl.PDFExtractionDao;
import org.apache.beam.sdk.options.DefaultValueFactory;
import org.apache.beam.sdk.options.PipelineOptions;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.UnknownKeyFor;

public class ExtractConfig {

    public static class ExtractionServiceFactory implements DefaultValueFactory<ExtractionService> {
        @Override
        public ExtractionService create(@UnknownKeyFor @NonNull @Initialized PipelineOptions options) {
            return new ExtractionService(new PDFExtractionDao());
        }
    }
}
