package com.librarySystem.service;


import com.librarySystem.Integrations.dto.BorrowingDto;

import java.util.Collection;

public interface BorrowingService {
    public Collection<BorrowingDto> getAllBorowingList();
    public BorrowingDto getBorrowingById(Integer id);
    public void update(BorrowingDto borrowingDto,Integer id );
    public void deleteById(Integer id);

    void addBorrowing(BorrowingDto borrowingDto);
}
