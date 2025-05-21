package com.mycompany.mathsnap;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DifficultySelectionController {
    @FXML private Button easyButton;
    @FXML private Button mediumButton;
    @FXML private Button hardButton;
    @FXML private Button backButton;

    private String selectedOperation;

    @FXML
    private void initialize() {
        easyButton.setOnAction(e -> handleDifficulty("EASY"));
        mediumButton.setOnAction(e -> handleDifficulty("MEDIUM"));
        hardButton.setOnAction(e -> handleDifficulty("HARD"));
        backButton.setOnAction(e -> {
            try {
                App.setRoot("OperationSelection");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public void initData(String operation) {
        this.selectedOperation = operation;
    }

    private void handleDifficulty(String difficulty) {
        System.out.println("Selected operation: " + selectedOperation + ", difficulty: " + difficulty);
        try {
            App.setRootWithData("Flashcard", controller -> {
                if (controller instanceof FlashcardController) {
                    ((FlashcardController) controller).initData(selectedOperation, difficulty);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
} 