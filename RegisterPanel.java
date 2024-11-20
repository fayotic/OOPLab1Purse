import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private final Register register = new Register();
    private final JTextField input = new JTextField(10);
    private final PursePanel changePanel = new PursePanel();
    //NEW STUFF
    private JComboBox comboBox;
    private JTextField textField;
    private JLabel label;
    JButton convertButton = new JButton("Convert"); //Button to convert
    JButton calculateButton = new JButton("Calculate Change"); //Button to calculate



    public RegisterPanel() {
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Amount:"));
        inputPanel.add(input);
        inputPanel.add(calculateButton);
        add(inputPanel, BorderLayout.NORTH);

        //NEW STUFF
        //Label/Field to put amount in
        JLabel amountLabel = new JLabel("Enter Amount to Convert:");
        changePanel.add(amountLabel, BorderLayout.SOUTH);
        textField = new JTextField(10);
        changePanel.add(textField, BorderLayout.CENTER);

        //Dropdown to choose which coin you can convert your change to
        JLabel coinLabel = new JLabel("Select Coin:");
        changePanel.add(coinLabel, BorderLayout.SOUTH);
        String[] coinTypes = {"Pennies", "Dimes", "Nickels", "Quarters"};
        comboBox = new JComboBox<>(coinTypes);
        changePanel.add(comboBox, BorderLayout.EAST);

        //Label
        label = new JLabel("Converted to: ");
        changePanel.add(label, BorderLayout.WEST);

        changePanel.add(convertButton, BorderLayout.WEST);

        // Change Panel
        add(changePanel, BorderLayout.CENTER);

        // Input Listener
        InputListener listener = new InputListener();
        calculateButton.addActionListener(listener);
        input.addActionListener(listener);

        InputListener listener2 = new InputListener();
        convertButton.addActionListener(listener2);
        input.addActionListener(listener2);
    }

    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == calculateButton){
                calculateChange();
            }
            else if (e.getSource() == convertButton){
                convertChange();
            }

        }
    }

    private void calculateChange(){
        try{
            double amount = Double.parseDouble(input.getText());
            Purse purse = register.makeChange(amount);
            changePanel.setPurse(purse);
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(RegisterPanel.this, "Invalid.");
        }

    }

    private void convertChange(){
        //Based on DropDown
        String coinSelected = (String) comboBox.getSelectedItem();
        //Gets user input from textbox
        String changeInput = textField.getText();

        try {
                //NEW STUFF
                double change = Double.parseDouble(changeInput); //converts user input to a double
                Conversion changeObj = new Change(change); //creates a base Conversion object

                //Dropdown selections, inserts base object into decorator functions
                switch (coinSelected) {
                    case "Pennies":
                        changeObj = new toPennies(changeObj);
                        break;
                    case "Dimes":
                        changeObj = new toDimes(changeObj);
                        break;
                    case "Nickels":
                        changeObj = new toNickels(changeObj);
                        break;
                    case "Quarters":
                        changeObj = new toQuarters(changeObj);
                        break;
                }
                //Converts the Change object based on decorators
                double resultForConversion = changeObj.convert();
                //Prints conversion
                label.setText("Converted to: " + resultForConversion + " " + coinSelected);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this, "Invalid.");

        }

    }
}
