package com.librarySystem.Integrations;

import com.librarySystem.domain.Book;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookAdapter {
    public static Book getBookFromBookDto(BookDTO bookDto){
        return new Book(bookDto.getIsbn(), bookDto.getTittle(), bookDto.getAuthor());
    }
    public static BookDTO getBookFromBookDto(Book book){
        return new BookDTO(book.getIsbn(), book.getTittle(), book.getAuthor());
    }
    public static Collection<BookDTO> getFromBooksToBooksDto(List<Book> books){
        List<BookDTO> booksDtos=new ArrayList<>();
        for (Book b:books) {
            booksDtos.add(getBookFromBookDto(b));
        }
        return booksDtos;
    }
}
