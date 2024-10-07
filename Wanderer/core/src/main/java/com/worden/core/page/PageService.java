package com.worden.core.page;

import com.worden.core.page.dao.PageIODao;
import com.worden.core.page.dao.PageProcessingDao;

public class PageService {

    private final PageProcessingDao pageProcessingDao;
    private final PageIODao pageIODao;

    public PageService(PageProcessingDao pageProcessingDao, PageIODao pageIODao) {
        this.pageProcessingDao = pageProcessingDao;
        this.pageIODao = pageIODao;
    }

}
