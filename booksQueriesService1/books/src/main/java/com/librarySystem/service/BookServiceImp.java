package com.librarySystem.service;

import com.librarySystem.domain.Book;
import com.librarySystem.Integrations.BookAdapter;
import com.librarySystem.DAO.BooksRepo;
import com.librarySystem.Integrations.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BookServiceImp implements BookService{
    @Autowired
    BooksRepo booksRepo;
    @Override
    public Collection<BookDto> getAllBooks() {
   List<Book>books=booksRepo.findAll();
        return BookAdapter.getFromBooksToBooksDto(books);
    }

    @Override
    public BookDto getBookById(String isbn) {
        Book book=booksRepo.findById(isbn).get();
        if (book==null){
            System.out.println("Book is not found");
        }
         return BookAdapter.getBookFromBookDto(book);
    }
}
