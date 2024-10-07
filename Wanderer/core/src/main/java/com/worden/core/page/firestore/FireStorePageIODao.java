package com.worden.core.page.firestore;

import java.util.List;

import com.worden.core.page.Page;
import com.worden.core.page.dao.PageIODao;

public class FireStorePageIODao implements PageIODao {

    @Override
    public Page readPages() {

        throw new UnsupportedOperationException("Unimplemented method 'readPages'");
    }

    @Override
    public boolean writePages(List<Page> pages) {
        throw new UnsupportedOperationException("Unimplemented method 'writePages'");
    }

}
