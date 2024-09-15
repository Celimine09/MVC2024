import java.io.File;
import Controller.FarmController;
import model.CreateCSV;
import model.FarmData;
import view.FarmView;

public class Main {
    public static void main(String[] args) {
        // Check animals.csv exist?
        File csvFile = new File("animals.csv");
        if (!csvFile.exists() || csvFile.length() == 0) {
            System.out.println("File not found or empty, running CreateCSV to generate data.");
            // Run CreateCSV To Create Data,if no data or no csv file
            try {
                CreateCSV.main(null);
            } catch (Exception e) {
                System.out.println("Error while creating CSV file.");
                e.printStackTrace();
                return;
            }
        } else { //Run normaly
            System.out.println("CSV file found with data, proceeding with main program.");
        }

        
        FarmData model = new FarmData();
        FarmView view = new FarmView();
        new FarmController(model, view);
    }
}
