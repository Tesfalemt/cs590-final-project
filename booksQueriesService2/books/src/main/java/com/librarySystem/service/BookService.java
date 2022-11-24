package com.librarySystem.service;

import com.librarySystem.Integrations.BookDto;

import java.util.Collection;

public interface BookService {
    public Collection<BookDto> getAllBooks();
    public BookDto getBookById(String isbn);
}
