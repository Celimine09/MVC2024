package Controller;

import java.io.File;

import model.CreateCSV;

public class DataInitializer {
    private static final String CSV_FILE_PATH = "animals.csv";
    
    public static void initializeData() {
        File csvFile = new File(CSV_FILE_PATH);
        if (!csvFile.exists() || csvFile.length() == 0) {
            System.out.println("File not found or empty, running CreateCSV to generate data.");
            try {
                CreateCSV.main(null);
            } catch (Exception e) {
                System.out.println("Error while creating CSV file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("CSV file found with data, proceeding with main program.");
        }
    }
}
