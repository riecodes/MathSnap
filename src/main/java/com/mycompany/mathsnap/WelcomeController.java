package com.mycompany.mathsnap;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WelcomeController {
    @FXML
    private Button startButton;

    @FXML
    private void initialize() {
        startButton.setOnAction(e -> {
            try {
                App.setRoot("OperationSelection");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
} 