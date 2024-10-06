package com.worden.file.impl;

import java.io.InputStream;

public interface FileDao {

    InputStream processFile(String filePath);

}
