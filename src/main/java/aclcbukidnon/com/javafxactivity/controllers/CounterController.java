package aclcbukidnon.com.javafxactivity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CounterController {

    @FXML
    private Label labelCount;

    // Variable to store the counter value
    private int counter = 0;

    @FXML
    protected void onPlusClick() {
        counter++;  // Increment the counter
        updateLabel();  // Update the label
    }

    @FXML
    protected void onMinusClick() {
        counter--;  // Decrement the counter
        updateLabel();  // Update the label
    }

    // Method to update the label with the current counter value
    private void updateLabel() {
        labelCount.setText(String.valueOf(counter));  // Display the counter value in the label
    }
}
