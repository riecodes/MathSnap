package com.mycompany.mathsnap;

import java.io.IOException;

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
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
} 