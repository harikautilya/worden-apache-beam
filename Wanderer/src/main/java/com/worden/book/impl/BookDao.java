package com.worden.book.impl;

import com.worden.book.Book;

import java.util.List;

public interface BookDao {

    List<Book> fetchBooks();
}
