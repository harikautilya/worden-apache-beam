package com.worden.book.impl;

import com.worden.book.Book;

import java.util.List;

public class PubSubBookDao implements BookDao {
    @Override
    public List<Book> fetchBooks() {
        return List.of(
                Book.builder().ofBookId(1).ofUrl("Data").build(),
                Book.builder().ofBookId(2).ofUrl("Data").build()
        );
    }
}
