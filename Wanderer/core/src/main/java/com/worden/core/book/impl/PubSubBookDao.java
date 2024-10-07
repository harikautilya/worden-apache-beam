package com.worden.core.book.impl;

import java.util.List;

import com.worden.core.book.Book;

public class PubSubBookDao implements BookDao {

    @Override
    public List<Book> fetchBooks() {
        return List.of(
                Book.builder().ofBookId(1).ofUrl("Data").build(),
                Book.builder().ofBookId(2).ofUrl("Data").build()
        );
    }
}
