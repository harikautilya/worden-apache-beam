package com.worden.file;

import com.worden.file.impl.WebFileDao;
import org.apache.beam.sdk.options.DefaultValueFactory;
import org.apache.beam.sdk.options.PipelineOptions;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.UnknownKeyFor;

public class FileConfig {


    public static class FileServiceFactory implements DefaultValueFactory<FileService> {
        @Override
        public FileService create(@UnknownKeyFor @NonNull @Initialized PipelineOptions options) {
            return new FileService(new WebFileDao());
        }
    }
}