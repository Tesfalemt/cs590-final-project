package com.librarySystem.service.dto;

import com.librarySystem.domain.Address;
import com.librarySystem.domain.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private long customerNumber;
    private String name;
    private Address address;
    private Contact contact;
}
