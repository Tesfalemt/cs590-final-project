package com.librarySystem.service;


import com.librarySystem.domain.Borrowing;
import com.librarySystem.Integrations.dto.BorrowingAdapter;
import com.librarySystem.Integrations.dto.BorrowingDto;
import com.librarySystem.DAO.BorrowingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BorrowingServiceImp implements BorrowingService {
    @Autowired
    BorrowingRepo borrowingRepo;

    @Override
    public Collection<BorrowingDto> getAllBorowingList() {
        List<Borrowing> borrowingCollection=borrowingRepo.findAll();
        return BorrowingAdapter.getFromBooksToBooksDto(borrowingCollection);
    }

    @Override
    public BorrowingDto getBorrowingById(Integer id) {
        Borrowing borrowing=borrowingRepo.findById(id).get();
        return BorrowingAdapter.getBookFromBookDto(borrowing);
    }

    @Override
    public void update(BorrowingDto borrowingDto, Integer id) {
        Borrowing borrowing=borrowingRepo.findById(id).get();
        borrowing.setBorrowingNumber(borrowingDto.getBorrowingNumber());
        borrowing.setLocalDate(borrowingDto.getLocalDate());
      borrowing.setCustomer(borrowingDto.getCustomer());
      borrowing.setBook(borrowingDto.getBook());
        borrowingRepo.save(borrowing);
    }

    @Override
    public void deleteById(Integer id) {
        borrowingRepo.deleteById(id);

    }

    @Override
    public void addBorrowing(BorrowingDto borrowingDto) {
        Borrowing borrowing=BorrowingAdapter.getBookFromBookDto(borrowingDto);
        borrowingRepo.save(borrowing);

    }


}
