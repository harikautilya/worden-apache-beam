package com.worden.common.book;

import com.worden.common.book.dao.BookDao;

public class BookService{

  private final BookDao pubsubBookDao;

  /**
   * Construcutor for the book service.
   *  
   * @param pubsubBookDao dao that uses pub sub as source.
   */
  public BookService(BookDao pubsubBookDao){
    this.pubsubBookDao = pubsubBookDao;
  }
  
}