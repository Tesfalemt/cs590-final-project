package com.librarySystem.Integrations;

import com.librarySystem.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private String isbn;
    private  String tittle;
    private String author;
    private List<Review> review;
}
