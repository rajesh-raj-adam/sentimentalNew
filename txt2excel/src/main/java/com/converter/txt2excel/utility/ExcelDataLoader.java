package com.converter.txt2excel.utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

import com.converter.txt2excel.model.Review;

@Component
public class ExcelDataLoader {

    public List<Review> loadReviewsFromExcel(String excelFilePath) {
        List<Review> reviews = new ArrayList<>();

        try (InputStream inputStream = new FileInputStream(excelFilePath);
             Workbook workbook = WorkbookFactory.create(inputStream)) {
            System.err.print("inside the xl sheet");         
            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Skip the header row

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String category = row.getCell(0).getStringCellValue();
            System.out.print(category);
                String product = row.getCell(1).getStringCellValue();
                int rating = (int) row.getCell(2).getNumericCellValue();
                String reviewText = row.getCell(3).getStringCellValue();

                Review review = new Review(category, product,rating, reviewText);
                reviews.add(review);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reviews;
    }
}
