package com.mycompany.mathsnap;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class OperationSelectionController {
    @FXML private Button additionButton;
    @FXML private Button subtractionButton;
    @FXML private Button multiplicationButton;
    @FXML private Button divisionButton;
    @FXML private Button backButton;

    @FXML
    private void initialize() {
        additionButton.setOnAction(e -> goToDifficulty("ADDITION"));
        subtractionButton.setOnAction(e -> goToDifficulty("SUBTRACTION"));
        multiplicationButton.setOnAction(e -> goToDifficulty("MULTIPLICATION"));
        divisionButton.setOnAction(e -> goToDifficulty("DIVISION"));
        backButton.setOnAction(e -> {
            try {
                App.setRoot("Welcome");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void goToDifficulty(String operation) {
        try {
            App.setRootWithData("DifficultySelection", controller -> {
                if (controller instanceof DifficultySelectionController) {
                    ((DifficultySelectionController) controller).initData(operation);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
} 