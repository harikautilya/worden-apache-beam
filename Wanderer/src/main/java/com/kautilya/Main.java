package com.kautilya;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        URL url=new URL("https://www.allthingsdistributed.com/files/amazon-dynamo-sosp2007.pdf");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(connection.getInputStream());
        PDDocument document = Loader.loadPDF(new RandomAccessReadBuffer(bufferedInputStream));
        System.out.println("Document loaded");
        PDFTextStripper stripper = new PDFTextStripper();
        int pagesToExtract = 2;
        for (int i = 0; i <= pagesToExtract; i++) {
            int page = i;
            stripper.setStartPage(page);
            stripper.setEndPage(page);
            String text = stripper.getText(document);
            System.out.println(text);
        }
        document.close();
    }
}