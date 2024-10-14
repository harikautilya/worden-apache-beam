package com.worden.common;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.values.PBegin;
import org.apache.beam.sdk.values.PCollection;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.UnknownKeyFor;

import com.worden.core.book.Book;
import com.worden.core.book.BookService;

import lombok.Builder;

public class BookIO {

    // Rule 1
    public static CollectBook collectBook(BookService service) {

        BookReadProvider provider = new BookReadProvider(service);
        return CollectBook.builder()
                .ofProvider(provider)
                .build();
    }

    // Rule 2
    public static class BookReadProvider {

        private final BookService service;

        public BookReadProvider(BookService service) {
            this.service = service;
        }

        List<ReadBook> getBooks() {
            List<Book> sourceBooks = service.getBooks();

            List<ReadBook> books = sourceBooks.stream()
                    .map((x) -> ReadBook.builder()
                    .ofBookUrl(x.getUrl())
                    .ofId(Long.valueOf(x.getBookId()))
                    .build()
                    ).collect(Collectors.toList());

            return books;

        }

    }

    // Rule 2
    public static class CollectBook extends PTransform<PBegin, PCollection<ReadBook>> {

        private final BookReadProvider provider;

        @Builder(setterPrefix = "of")
        public CollectBook(BookReadProvider provider) {
            this.provider = provider;
        }

        @Override
        @UnknownKeyFor
        @NonNull
        @Initialized
        public PCollection<ReadBook> expand(PBegin input) {
            // Rule 3
            return input.apply("Read book messages", Create.of(provider.getBooks()));
        }

    }

}
