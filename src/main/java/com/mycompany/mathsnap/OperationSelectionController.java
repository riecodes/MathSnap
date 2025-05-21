package com.mycompany.mathsnap;

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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    private void goToDifficulty(String operation) {
        FlashcardSession.getInstance().setOperation(operation);
        App.setRoot("DifficultySelection");
    }
} 