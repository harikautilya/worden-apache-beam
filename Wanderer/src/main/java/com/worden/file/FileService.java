package com.worden.file;

import com.worden.file.impl.FileDao;

import java.io.InputStream;

public class FileService {

    private final FileDao fileDao;

    public FileService(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    public InputStream readFileFromUrl(String url){
        return fileDao.processFile(url);
    }
}
