package com.worden.wanderer.config;

import org.apache.beam.sdk.options.DefaultValueFactory;
import org.apache.beam.sdk.options.PipelineOptions;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.UnknownKeyFor;

import com.worden.core.extract.ExtractionService;
import com.worden.core.extract.impl.PDFExtractionDao;

public class ExtractConfig {

    public static class ExtractionServiceFactory implements DefaultValueFactory<ExtractionService> {

        @Override
        public ExtractionService create(@UnknownKeyFor @NonNull @Initialized PipelineOptions options) {
            return new ExtractionService(new PDFExtractionDao());
        }
    }
}
