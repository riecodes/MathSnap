package com.mycompany.mathsnap;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DifficultySelectionController {
    @FXML private Button easyButton;
    @FXML private Button mediumButton;
    @FXML private Button hardButton;
    @FXML private Button backButton;

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

    private void handleDifficulty(String difficulty) {
        System.out.println("Selected operation: " + AppContext.selectedOperation + ", difficulty: " + difficulty);
        // TODO: Navigate to Flashcard screen and pass operation + difficulty
    }
} 