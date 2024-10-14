package com.worden.reader;

import org.apache.beam.sdk.options.DefaultValueFactory;
import org.apache.beam.sdk.options.PipelineOptions;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.UnknownKeyFor;

import com.worden.core.book.BookService;
import com.worden.core.book.impl.PubSubBookDao;

import autovalue.shaded.org.checkerframework.checker.nullness.qual.NonNull;

public class Config {

    public static class BookServiceFactory implements DefaultValueFactory<BookService> {

        @Override
        public BookService create(@UnknownKeyFor @NonNull @Initialized PipelineOptions options) {
            return new BookService(new PubSubBookDao());
        }
    }
}
