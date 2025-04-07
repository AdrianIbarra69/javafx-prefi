package aclcbukidnon.com.javafxactivity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class CalculatorController {

    @FXML
    private Label displayLabel; // To show the calculation result

    private String currentInput = ""; // Holds the current input or expression
    private double firstOperand = 0; // Holds the first operand for calculation
    private String operator = ""; // Holds the current operator

    @FXML
    public void initialize() {
        displayLabel.setText("0");
    }

    // Event handler for number buttons (0-9)
    @FXML
    private void onNumberClick(javafx.event.ActionEvent event) {
        Button source = (Button) event.getSource();
        String clickedButton = source.getText();

        // Append clicked number to the current input
        if (currentInput.equals("0")) {
            currentInput = clickedButton; // Avoid leading zeros
        } else {
            currentInput += clickedButton;
        }

        displayLabel.setText(currentInput); // Update the display
    }

    // Event handler for operator buttons (+, -, *, /)
    @FXML
    private void onOperatorClick(javafx.event.ActionEvent event) {
        Button source = (Button) event.getSource();
        operator = source.getText(); // Get the operator clicked

        // If there's already an input, store the current input as the first operand
        if (!currentInput.isEmpty()) {
            firstOperand = Double.parseDouble(currentInput);
            currentInput = ""; // Clear input after storing first operand
        }
    }

    // Event handler for the "CLEAR" button
    @FXML
    private void onClearClick(javafx.event.ActionEvent event) {
        currentInput = "";
        firstOperand = 0;
        operator = "";
        displayLabel.setText("0");
    }

    // Event handler for the "BCKSPC" button (backspace)
    @FXML
    private void onBackspaceClick(javafx.event.ActionEvent event) {
        if (currentInput.length() > 0) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            displayLabel.setText(currentInput.isEmpty() ? "0" : currentInput);
        }
    }

    // Event handler for the decimal point button
    @FXML
    private void onDecimalClick(javafx.event.ActionEvent event) {
        if (!currentInput.contains(".")) {
            currentInput += ".";
            displayLabel.setText(currentInput);
        }
    }

    // Event handler for the "=" button (calculate result)
    @FXML
    private void onEqualClick(javafx.event.ActionEvent event) {
        if (!currentInput.isEmpty()) {
            double secondOperand = Double.parseDouble(currentInput);
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        displayLabel.setText("Error");
                        return;
                    }
                    break;
            }

            displayLabel.setText(String.valueOf(result));
            currentInput = String.valueOf(result); // Store the result as the next input
        }
    }
}
