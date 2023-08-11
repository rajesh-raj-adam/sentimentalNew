package com.converter.txt2excel.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.converter.txt2excel.model.Review;
import com.converter.txt2excel.repository.ReviewRepository;

@Service("reviewService")
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }
}
