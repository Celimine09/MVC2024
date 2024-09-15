package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import model.Cow;
import model.FarmData;
import model.Goat;
import view.FarmView;

public class FarmController {
    private FarmData model;
    private FarmView view;

    public FarmController(FarmData model, FarmView view) {
        this.model = model;
        this.view = view;

        this.view.setProcessButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processInput(view.getInput());
            }
        });
    }

    private void processInput(String id) { //CheckID
        if (!id.matches("[1-9][0-9]{7}")) {
            view.showResult("Invalid ID. Must be 8 digits, starting with a non-zero.");
            return;
        }

        Cow cow = model.findCowById(id);
        Goat goat = model.findGoatById(id);

        if (cow != null) { //Show Cow Detail
            showAnimalDetails(cow);
            CheckCow(cow);
        } else if (goat != null) { //Its Goat
            showAnimalDetails(goat);
            view.showResult("Goat detected! Send it back to the mountain!");
        } else { //No Animal ID
            view.showResult("Animal not found!");
        }

        // Save changes back to CSV after processing
        model.saveAnimalsToCSV();
    }

    private void CheckCow(Cow cow) { //Check Cow Udders
        if (cow.getUdderCount() == 4) {
            int milkProduced = cow.getAgeYears() + cow.getAgeMonths();
            view.showResult("Cow can be milked! Milk produced: " + milkProduced + " liters.");
            updateUdderCount(cow, 5);
        } else { 
            view.showResult("Cow is not healthy for milking (less than 4 udders).");
            updateUdderCount(cow, 20);
        }
    }

    private void updateUdderCount(Cow cow, int chance) {  
        Random rand = new Random();
        if (cow.getUdderCount() == 4 && rand.nextInt(100) < chance) { //Chance to lost udders
            cow.setUdderCount(3);
            view.showResult("Accident! One udder was lost.");
        } else if (cow.getUdderCount() == 3 && rand.nextInt(100) < chance) { //Chance to recover udders
            cow.setUdderCount(4);
            view.showResult("Recovery! Cow regained an udder.");
        }
    }

    private void showAnimalDetails(Cow cow) { //Display Cow Details
        String info = "Animal Type: Cow\n"
                + "ID: " + cow.getId() + "\n"
                + "Age: " + cow.getAgeYears() + " years, " + cow.getAgeMonths() + " months\n"
                + "Udder Count: " + cow.getUdderCount();
        view.showAnimalInfo(info);
    }

    private void showAnimalDetails(Goat goat) { //Display Goat Details
        String info = "Animal Type: Goat\n"
                + "ID: " + goat.getId() + "\n"
                + "No additional data available.";
        view.showAnimalInfo(info);
    }

    
}
