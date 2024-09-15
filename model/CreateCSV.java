package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CreateCSV {
    public static void main(String[] args) {
        String filePath = "animals.csv"; 
        Random random = new Random(); // Random Age and Udders

        try (FileWriter writer = new FileWriter(filePath)) {
            //Write Down Data
            writer.write("ID,Type,AgeYears,AgeMonths,UdderCount\n");

            // Generate Cow 
            for (int i = 1; i <= 15; i++) {
                String id = String.format("%08d", 10000000 + i); // CowID
                int ageYears = random.nextInt(11); // CowAge_Year
                int ageMonths = random.nextInt(12); // CowAge_Month
                int udderCount = random.nextBoolean() ? 4 : 3; // CowUdder
                writer.write(String.format("%s,Cow,%d,%d,%d\n", id, ageYears, ageMonths, udderCount));
            }

            // GenerateGoat
            writer.write("10000016,Goat,,,\n"); // First Goat(Messi)
            writer.write("10000017,Goat,,,\n"); // Second Goat(Ronaldo)

            System.out.println("CSV file created successfully with 15 cows and 2 goats.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the CSV file.");
            e.printStackTrace();
        }
    }
}
