package com.librarySystem.service;

import com.librarySystem.Integration.Sender;
import com.librarySystem.domain.Review;
import com.librarySystem.Integrations.ReviewAdapter;
import com.librarySystem.Integrations.ReviewDto;
import com.librarySystem.DAO.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImp implements ReviewService {
    @Autowired
    ReviewRepo reviewRepo;
    @Autowired
    Sender sender;
    @Override
    public void addBReviewToBook(ReviewDto reviewDto) {
        Review review= ReviewAdapter.gerReviewFromReviewDto(reviewDto);
        reviewRepo.save(review);
        System.out.println("Sending ReviewDTO");
        sender.send(reviewDto);

    }
}
