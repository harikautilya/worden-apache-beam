package com.worden.core.book;

import java.util.List;

import com.worden.core.book.impl.BookDao;

public class BookService {

    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> getBooks() {
        return bookDao.fetchBooks();
    }
}
