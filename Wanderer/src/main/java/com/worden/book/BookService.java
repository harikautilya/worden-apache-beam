package com.worden.book;

import com.worden.book.impl.BookDao;

import java.util.List;

public class BookService {

    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> getBooks() {
        return bookDao.fetchBooks();
    }
}
