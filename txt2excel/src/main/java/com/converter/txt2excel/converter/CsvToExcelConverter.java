package com.converter.txt2excel.converter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CsvToExcelConverter {

    public static void main(String[] args) {
        String csvFilePath = "C:\\Users\\Rohit Adam\\Videos\\SentimentAnalysis\\txtToExcel\\txt2excel\\src\\main\\java\\com\\converter\\txt2excel\\converter\\input.txt"; // Replace with your CSV file path
        String excelFilePath = "output.xlsx"; // Replace with your desired Excel file path

        try {
            convertCsvToExcel(csvFilePath, excelFilePath);
            System.out.println("Conversion complete. Excel file generated.");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static void convertCsvToExcel(String csvFilePath, String excelFilePath) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
             Workbook workbook = new XSSFWorkbook();
             FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {

            Sheet sheet = workbook.createSheet("Product Reviews");

            String line;
            int rowNum = 0;
            while ((line = reader.readLine()) != null) {
                Row row = sheet.createRow(rowNum++);
                String[] columns = line.split(",");
                for (int i = 0; i < columns.length; i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(columns[i]);
                }
            }

            workbook.write(outputStream);
        }
    }
}
