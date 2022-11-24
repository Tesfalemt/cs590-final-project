package com.librarySystem.service;

import com.librarySystem.Integrations.BookDTO;


public interface BookService {
    public void addBook(BookDTO booksDto);
    public void updateBook(BookDTO booksDto, String isbn);
    public void deleteById(String isbn);

}
