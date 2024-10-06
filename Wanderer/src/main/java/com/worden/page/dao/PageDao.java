package com.worden.page.dao;

import com.worden.extract.ExtractedText;
import com.worden.page.Page;

public interface PageDao {

    Page getWords(Page Page);

    int getOddWordCount(Page page);

    int getEvenWordCount(Page page);

    int getWordCount(Page page);
}
