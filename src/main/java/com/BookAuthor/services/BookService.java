package com.BookAuthor.services;

import com.BookAuthor.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto addBook(long authorId, BookDto bookDto);

    BookDto getOneBook(long bookId);

    List<BookDto> getAllBook();

    BookDto UpdateOneBook(long bookId, BookDto bookDto);

    void deleteOneBook(long bookId);
}
