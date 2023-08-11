package com.converter.txt2excel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.converter.txt2excel.model.Review;

@Repository("reviewRepository")
public interface ReviewRepository extends MongoRepository<Review, String> {
    // Additional custom query methods can be defined here if needed
}