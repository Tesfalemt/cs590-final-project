package com.librarySystem.Integrations;

import com.librarySystem.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {


        private Integer reviewId;
        private int reviewRating;
        private String description;
        private Book book;

}
