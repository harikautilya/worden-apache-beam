package com.worden.core.file;

import java.io.InputStream;

import com.worden.core.file.impl.FileDao;

public class FileService {

    private final FileDao fileDao;

    public FileService(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    public InputStream readFileFromUrl(String url) {
        return fileDao.processFile(url);
    }
}
