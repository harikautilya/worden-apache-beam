package com.worden.wanderer.config;

import org.apache.beam.sdk.options.DefaultValueFactory;
import org.apache.beam.sdk.options.PipelineOptions;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.UnknownKeyFor;

import com.worden.core.page.PageService;
import com.worden.core.page.dao.WordCountDao;
import com.worden.core.page.firestore.FireStorePageIODao;

public class PageConfig {

    public static class PageServiceFactory implements DefaultValueFactory<PageService> {

        @Override
        public PageService create(@UnknownKeyFor @NonNull @Initialized PipelineOptions options) {
            return new PageService(new WordCountDao(), new FireStorePageIODao());
        }
    }
}
