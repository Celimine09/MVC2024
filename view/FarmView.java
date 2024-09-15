package view;
import javax.swing.*;
import java.awt.event.ActionListener;

public class FarmView {
    private JFrame frame;
    private JTextField inputField;
    private JButton processButton;
    private JLabel resultLabel;
    private JTextArea infoArea;

    public FarmView() {
        frame = new JFrame("Cow Milking Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        inputField = new JTextField(10);
        processButton = new JButton("Process");
        resultLabel = new JLabel("Enter the animal ID:"); //Input ID
        infoArea = new JTextArea(5, 30); // TextArea to show animal information
        infoArea.setEditable(false);

        frame.setLayout(new java.awt.FlowLayout());
        frame.add(resultLabel);
        frame.add(inputField);
        frame.add(processButton);
        frame.add(new JScrollPane(infoArea));

        frame.setVisible(true);
    }

    public void setProcessButtonListener(ActionListener listener) {
        processButton.addActionListener(listener);
    }

    public String getInput() {
        return inputField.getText();
    }

    public void showResult(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    // Method to display animal information
    public void showAnimalInfo(String info) {
        infoArea.setText(info);
    }
}
