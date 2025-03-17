import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField display;
    private double result = 0;
    private String lastCommand = "=";
    private boolean start = true;

    public Calculator() {
        setTitle("Калькулятор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);

        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "CE", "√", "x²"
        };

        for (String label : buttons) {
            JButton button = new JButton(label);
            buttonPanel.add(button);
            if (label.matches("[0-9.]")) {
                button.addActionListener(new NumberListener());
            } else {
                button.addActionListener(new OperatorListener());
            }
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private class NumberListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String digit = event.getActionCommand();
            if (start) {
                display.setText(digit);
                start = false;
            } else {
                display.setText(display.getText() + digit);
            }
        }
    }

    private class OperatorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            
            if (command.equals("C")) {
                display.setText("0");
                start = true;
            } else if (command.equals("CE")) {
                display.setText("0");
                start = true;
            } else if (command.equals("√")) {
                double x = Double.parseDouble(display.getText());
                display.setText("" + Math.sqrt(x));
                start = true;
            } else if (command.equals("x²")) {
                double x = Double.parseDouble(display.getText());
                display.setText("" + (x * x));
                start = true;
            } else {
                if (!start) {
                    calculate();
                    lastCommand = command;
                    start = true;
                }
            }
        }
    }

    public void calculate() {
        double x = Double.parseDouble(display.getText());
        switch (lastCommand) {
            case "+": result += x; break;
            case "-": result -= x; break;
            case "*": result *= x; break;
            case "/": result /= x; break;
        }
        display.setText("" + result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calc = new Calculator();
            calc.setVisible(true);
        });
    }
} 