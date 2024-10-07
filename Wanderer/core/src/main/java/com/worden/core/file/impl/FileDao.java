package com.worden.core.file.impl;

import java.io.InputStream;

public interface FileDao {

    InputStream processFile(String filePath);

}
