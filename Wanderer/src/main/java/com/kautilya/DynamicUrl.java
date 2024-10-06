package com.kautilya;

import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadView;

import java.io.IOException;

public class DynamicUrl implements RandomAccessRead {
    @Override
    public int read() throws IOException {
        return 0;
    }

    @Override
    public int read(byte[] bytes, int i, int i1) throws IOException {
        return 0;
    }

    @Override
    public long getPosition() throws IOException {
        return 0;
    }

    @Override
    public void seek(long l) throws IOException {

    }

    @Override
    public long length() throws IOException {
        return 0;
    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public boolean isEOF() throws IOException {
        return false;
    }

    @Override
    public RandomAccessReadView createView(long l, long l1) throws IOException {
        return null;
    }

    @Override
    public void close() throws IOException {

    }
}
