package com.librarySystem.Integrations.dto;


import com.librarySystem.domain.Book;
import com.librarySystem.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingDto {
    private Integer borrowingNumber;
    private String localDate;
    private Customer customer;
    private Book book;
}
