package com.librarySystem.service;

import com.librarySystem.domain.Book;
import com.librarySystem.Integrations.BookAdapter;
import com.librarySystem.Integrations.BookDTO;
import com.librarySystem.Integrations.Sender;
import com.librarySystem.DAO.BooksRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService{
    @Autowired
    BooksRepo booksRepo;
@Autowired
Sender sender;

    @Override
    public void addBook(BookDTO booksDto) {
        Book book= BookAdapter.getBookFromBookDto(booksDto);
        booksRepo.save(book);
        sender.send(BookAdapter.getBookFromBookDto(book));
        System.out.println("sending Book DTO");
    }

    @Override
    public void updateBook(BookDTO booksDto, String isbn) {
        Book book=booksRepo.findById(isbn).get();
        if (book!=null){
            book.setIsbn(booksDto.getIsbn());
            book.setTittle(booksDto.getTittle());
            book.setAuthor(booksDto.getAuthor());
            sender.send(BookAdapter.getBookFromBookDto(book));
            System.out.println("Sending updatedBook);

        }

    }

    @Override
    public void deleteById(String isbn) {
        Book book=booksRepo.findById(isbn).get();
        booksRepo.delete(book);
       sender.send(BookAdapter.getBookFromBookDto(book));
        System.out.println("Delete book ");

    }
}
