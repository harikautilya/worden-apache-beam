package com.worden.page;

import com.worden.page.dao.PageDao;

public class PageService {

    private final PageDao pageDao;


    public PageService(PageDao pageDao) {
        this.pageDao = pageDao;
    }

    Page extractWords(Page page) {
        Page newPageObj = pageDao.getWords(page);
        return newPageObj;
    }


    int getScore(Page page) {
        return -1;
    }
}
