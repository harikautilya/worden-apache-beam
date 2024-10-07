package com.worden.core.page.dao;

import com.worden.core.page.Page;

public interface PageProcessingDao {

    Page getWords(Page Page);

    int getOddWordCount(Page page);

    int getEvenWordCount(Page page);

    int getWordCount(Page page);
}
