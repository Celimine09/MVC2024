package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FarmData {
    private List<Cow> cows;
    private List<Goat> goats;
    private static final String CSV_FILE_PATH = "animals.csv";

    public FarmData() {
        this.cows = new ArrayList<>();
        this.goats = new ArrayList<>();
        loadAnimalsFromCSV();
    }

    private void loadAnimalsFromCSV() { //Load Data From CSV
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line = reader.readLine(); 
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0].trim(); 
                String type = data[1].trim();
    
                if (type.equals("Cow")) { 
                    int ageYears = Integer.parseInt(data[2].trim());
                    int ageMonths = Integer.parseInt(data[3].trim());
                    int udderCount = Integer.parseInt(data[4].trim());
                    cows.add(new Cow(id, ageYears, ageMonths, udderCount));
                } else if (type.equals("Goat")) {
                    goats.add(new Goat(id));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void saveAnimalsToCSV() {
        try (FileWriter writer = new FileWriter(CSV_FILE_PATH)) {
            writer.write("ID,Type,AgeYears,AgeMonths,UdderCount\n");
            for (Cow cow : cows) { //Loop Save Cow Data
                writer.write(cow.getId() + ",Cow," + cow.getAgeYears() + "," + cow.getAgeMonths() + "," + cow.getUdderCount() + "\n");
            }
            for (Goat goat : goats) { //Loop Save Goat Data
                writer.write(goat.getId() + ",Goat,,,\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cow findCowById(String id) {
        for (Cow cow : cows) {
            if (cow.getId().equals(id)) {
                return cow;
            }
        }
        return null;
    }

    public Goat findGoatById(String id) {
        for (Goat goat : goats) {
            if (goat.getId().equals(id)) {
                return goat;
            }
        }
        return null;
    }
}
