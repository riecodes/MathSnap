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
        mediumButton.setOnAction(e -> handleDifficulty("MODERATE"));
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
        FlashcardSession.getInstance().setDifficulty(difficulty);
        FlashcardSession.getInstance().generateNewProblem();
        App.setRoot("Flashcard");
    }
} 