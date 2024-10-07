package com.worden.core.page.dao;

import java.util.List;

import com.worden.core.page.Page;

public interface PageIODao {

    Page readPages();

    boolean writePages(List<Page> pages);

}
