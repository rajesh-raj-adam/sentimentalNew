package com.converter.txt2excel.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Document(collection = "reviews")
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    
    public Review(String category2, String product2, Integer rating2, String reviewText2) {
        this.category=category2;
        this.product=product2;
        this.rating=rating2;
        this.reviewText=reviewText2;
    }
    @Id
    private String id;
    private String category;
    private String product;
    private Integer rating;
    private String reviewText;
}
