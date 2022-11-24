package com.librarySystem.controller;


import com.librarySystem.service.BorrowingServiceImp;
import com.librarySystem.Integrations.dto.BorrowingDto;
import com.librarySystem.Integrations.dto.BorrowingListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/borrowing")
public class BorrowingController {
    @Autowired
    BorrowingServiceImp borrowingService;


    @GetMapping()
    public ResponseEntity<?> getAllBorowing(){
       Collection <BorrowingDto> booksDto=borrowingService.getAllBorowingList();
        BorrowingListDto booksDto1=new BorrowingListDto(booksDto);
        return new ResponseEntity<>(booksDto1, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> addBorrowing(@RequestBody BorrowingDto borrowingDto){
        borrowingService.addBorrowing(borrowingDto);
        return new ResponseEntity<>(borrowingDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBorrowing(@PathVariable Integer id){
       borrowingService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBorrowing( @RequestBody BorrowingDto borrowingDto,@PathVariable Integer id){
        borrowingService.update(borrowingDto,id);
        return new ResponseEntity<>(borrowingDto,HttpStatus.FOUND);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBorrowing(@PathVariable Integer id){
        return  new ResponseEntity<>(borrowingService.getBorrowingById(id),HttpStatus.FOUND);
    }


}
