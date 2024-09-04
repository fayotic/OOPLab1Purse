import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private final Register register = new Register();
    private final JTextField input = new JTextField(10);
    private final PursePanel changePanel = new PursePanel();

    public RegisterPanel() {
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Amount:"));
        inputPanel.add(input);
        JButton calculateButton = new JButton("Calculate Change");
        inputPanel.add(calculateButton);
        add(inputPanel, BorderLayout.NORTH);

        // Change Panel
        add(changePanel, BorderLayout.CENTER);

        // Input Listener
        InputListener listener = new InputListener();
        calculateButton.addActionListener(listener);
        input.addActionListener(listener);
    }

    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(input.getText());
                Purse purse = register.makeChange(amount);
                changePanel.setPurse(purse);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this, "Invalid amount. Please enter a valid number.");
            }
        }
    }
}
