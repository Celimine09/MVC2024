import Controller.DataInitializer;
import Controller.FarmController;
import model.FarmData;
import view.FarmView;

public class Main {
    public static void main(String[] args) {
        // Initialize data
        DataInitializer.initializeData();
        
        // Initialize FarmData and FarmView
        FarmData model = new FarmData();
        FarmView view = new FarmView();
        
        new FarmController(model, view);
    }
}
