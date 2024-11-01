package com.worden.common.book.dao;

import java.util.List;

import com.worden.core.book.Book;

/**
 * Dao layer for book feature.
 */
public interface BookDao {

  /**
   * Get list of book from the source.
   * 
   * @return list of books  {@link Book}
   */
  List<Book> getBooks();

  /**
   * Add a single book to the source.
   * 
   * @param book {@link Book}
   */
  boolean addBook(Book book);

} 
