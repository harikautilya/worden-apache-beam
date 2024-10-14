package com.worden.reader;

import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.StreamingOptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.worden.core.book.BookService;

public interface ReaderOptions extends StreamingOptions {

    @JsonIgnore
    @Default.InstanceFactory(Config.BookServiceFactory.class)
    BookService getBookService();

    void setBookService(BookService bookService);

}
