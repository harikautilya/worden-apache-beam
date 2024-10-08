package com.worden.wanderer.config;

import org.apache.beam.sdk.options.DefaultValueFactory;
import org.apache.beam.sdk.options.PipelineOptions;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.UnknownKeyFor;

import com.worden.core.book.BookService;
import com.worden.core.book.impl.PubSubBookDao;

public class BookConfig {

    public static class BookServiceFactory implements DefaultValueFactory<BookService> {

        @Override
        public BookService create(@UnknownKeyFor @NonNull @Initialized PipelineOptions options) {
            return new BookService(new PubSubBookDao());
        }
    }
}
