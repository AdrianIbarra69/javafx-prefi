package aclcbukidnon.com.javafxactivity.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class TrafficLightController {

    // Enum representing the traffic light colors
    private enum TrafficLightColor {
        STOP,   // Red light
        HOLD,   // Yellow light
        GO,     // Green light
    }

    // Current traffic light color
    private TrafficLightColor currentColor = TrafficLightColor.STOP;

    // Timeline for switching lights every few seconds
    private Timeline timeline;

    @FXML
    private Circle redLight;    // Red light circle
    @FXML
    private Circle yellowLight; // Yellow light circle
    @FXML
    private Circle greenLight;  // Green light circle

    @FXML
    public void initialize() {
        // Set up the timeline to change the light color every 3 seconds
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(3), e -> onTimerChange())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play(); // Start the timeline when the application runs
    }

    // Called when the timer elapses (every 3 seconds)
    private void onTimerChange() {
        // Update the current traffic light color
        switch (currentColor) {
            case STOP:
                currentColor = TrafficLightColor.GO;
                break;
            case HOLD:
                currentColor = TrafficLightColor.STOP;
                break;
            case GO:
                currentColor = TrafficLightColor.HOLD;
                break;
        }

        // Update the UI to reflect the current color
        updateTrafficLight();
    }

    // Update the UI elements to reflect the current color
    private void updateTrafficLight() {
        // Reset all lights to transparent
        redLight.setFill(Color.GRAY);
        yellowLight.setFill(Color.GRAY);
        greenLight.setFill(Color.GRAY);

        // Set the current color light to bright color
        switch (currentColor) {
            case STOP:
                redLight.setFill(Color.RED);
                break;
            case HOLD:
                yellowLight.setFill(Color.YELLOW);
                break;
            case GO:
                greenLight.setFill(Color.GREEN);
                break;
        }
    }

    // Optionally, you can add a button to manually start/stop the traffic light cycle
    @FXML
    private Button startButton;

    @FXML
    private void onStartButtonClick() {
        if (!timeline.getStatus().equals(Timeline.Status.RUNNING)) {
            timeline.play(); // Start the timeline if it's not already running
        }
    }

    @FXML
    private void onStopButtonClick() {
        if (timeline.getStatus().equals(Timeline.Status.RUNNING)) {
            timeline.pause(); // Pause the timeline
        }
    }
}
