package com.worden.core.book.impl;

import java.util.List;

import com.worden.core.book.Book;

public interface BookDao {

    List<Book> fetchBooks();
}
