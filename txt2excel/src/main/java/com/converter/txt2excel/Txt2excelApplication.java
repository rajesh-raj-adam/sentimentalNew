package com.converter.txt2excel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.converter.txt2excel.model.Review;
import com.converter.txt2excel.repository.ReviewRepository;
import com.converter.txt2excel.utility.ExcelDataLoader;

@SpringBootApplication
public class Txt2excelApplication implements CommandLineRunner{

	@Autowired
    private ExcelDataLoader excelDataLoader;
	@Autowired
	private ReviewRepository reviewRepository;
	public static void main(String[] args) {
		SpringApplication.run(Txt2excelApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        List<Review> reviews = excelDataLoader.loadReviewsFromExcel("C:\\Users\\Rohit Adam\\Videos\\SentimentAnalysis\\txtToExcel\\txt2excel\\output.xlsx");
		reviews.forEach((review)->reviewRepository.save(review));
        // Now you have the List<Review> reviews loaded from the Excel file
        // You can process and save them to MongoDB as shown in the previous responses
    }
}
