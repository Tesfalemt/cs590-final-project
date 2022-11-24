package com.librarySystem.controller;


import com.librarySystem.Integrations.BookDTO;
import com.librarySystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bookcommand")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping()
    public void addBook(@RequestBody BookDTO bookDto){
        bookService.addBook(bookDto);
    }
    @PutMapping("/update/{isbn}")
    public void updateBook(@RequestBody BookDTO bookDto, @PathVariable("isbn") String isbn){
        bookService.updateBook(bookDto,isbn);
    }
    @DeleteMapping("/isbn")
    public void deleteById(@PathVariable String isbn){
        bookService.deleteById(isbn);
    }

    
}
