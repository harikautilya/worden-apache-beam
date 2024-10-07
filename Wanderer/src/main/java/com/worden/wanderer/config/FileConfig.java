package com.worden.wanderer.config;

import org.apache.beam.sdk.options.DefaultValueFactory;
import org.apache.beam.sdk.options.PipelineOptions;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.UnknownKeyFor;

import com.worden.core.file.FileService;
import com.worden.core.file.impl.WebFileDao;

public class FileConfig {

    public static class FileServiceFactory implements DefaultValueFactory<FileService> {

        @Override
        public FileService create(@UnknownKeyFor @NonNull @Initialized PipelineOptions options) {
            return new FileService(new WebFileDao());
        }
    }
}
