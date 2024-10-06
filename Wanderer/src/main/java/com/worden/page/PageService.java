package com.worden.page;

import com.worden.page.dao.PageDao;

public class PageService {

    private final PageDao pageDao;


    public PageService(PageDao pageDao) {
        this.pageDao = pageDao;
    }

    Page extractWords(Page page) {
        return page;
    }
}
