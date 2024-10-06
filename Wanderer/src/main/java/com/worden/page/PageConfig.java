package com.worden.page;

import com.worden.extract.ExtractionService;
import com.worden.extract.impl.PDFExtractionDao;
import com.worden.page.dao.WordCountDao;
import org.apache.beam.sdk.options.DefaultValueFactory;
import org.apache.beam.sdk.options.PipelineOptions;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.UnknownKeyFor;

public class PageConfig {

    public static class PageServiceFactory implements DefaultValueFactory<PageService> {
        @Override
        public PageService create(@UnknownKeyFor @NonNull @Initialized PipelineOptions options) {
            return new PageService(new WordCountDao());
        }
    }
}
