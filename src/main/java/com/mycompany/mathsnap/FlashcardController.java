package com.mycompany.mathsnap;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FlashcardController {
    @FXML private Label operationLabel;
    @FXML private Text operand1Text;
    @FXML private Text operatorText;
    @FXML private Text operand2Text;
    @FXML private TextField answerField;
    @FXML private Button enterButton;
    @FXML private Button backButton;
    @FXML private Button nextButton;
    @FXML private Label difficultyBadge;
    @FXML private Text feedbackText;

    @FXML
    private void initialize() {
        updateFlashcardUI();
        enterButton.setOnAction(e -> {
            System.out.println("Enter button clicked");
            checkAnswer();
        });
        nextButton.setOnAction(e -> {
            System.out.println("Next button clicked");
            FlashcardSession.getInstance().generateNewProblem();
            updateFlashcardUI();
        });
        backButton.setOnAction(e -> {
            System.out.println("Back button clicked");
            App.setRoot("DifficultySelection");
            System.out.println("Navigation attempted to DifficultySelection.fxml");
        });
        answerField.setOnAction(e -> {
            System.out.println("Answer field Enter pressed");
            checkAnswer();
        });
    }

    private void updateFlashcardUI() {
        FlashcardSession session = FlashcardSession.getInstance();
        MathProblem problem = session.getCurrentProblem();
        String op = session.getOperation();
        String diff = session.getDifficulty();
        if (problem == null || op == null || diff == null) {
            System.out.println("updateFlashcardUI: missing data");
            return;
        }
        operationLabel.setText(getOperationText(op));
        operationLabel.getStyleClass().removeAll("add-label", "subtract-label", "multiply-label", "divide-label");
        operationLabel.getStyleClass().add(getOperationLabelClass(op));
        operand1Text.setText(String.valueOf(problem.getOperand1()));
        operatorText.setText(problem.getOperator());
        operand2Text.setText(String.valueOf(problem.getOperand2()));
        answerField.setText("");
        answerField.setStyle("");
        feedbackText.setText("");
        feedbackText.setStyle("");
        difficultyBadge.setText(getDifficultyText(diff));
        difficultyBadge.getStyleClass().removeAll("easy-badge", "medium-badge", "hard-badge");
        difficultyBadge.getStyleClass().add(getDifficultyBadgeClass(diff));
    }

    private void checkAnswer() {
        FlashcardSession session = FlashcardSession.getInstance();
        MathProblem problem = session.getCurrentProblem();
        try {
            int userAnswer = Integer.parseInt(answerField.getText().trim());
            if (userAnswer == problem.getCorrectAnswer()) {
                answerField.setStyle("-fx-border-color: #8BC34A; -fx-border-width: 3px; -fx-width: 500px;"); // Green
                feedbackText.setText("Nice!");
                feedbackText.setStyle("-fx-fill: #8BC34A; -fx-font-size: 24px; -fx-font-weight: bold;");
                System.out.println("Correct answer!");
                // Auto-generate new problem after 1 second
                new Thread(() -> {
                    try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
                    javafx.application.Platform.runLater(() -> {
                        session.generateNewProblem();
                        updateFlashcardUI();
                    });
                }).start();
            } else {
                answerField.setStyle("-fx-border-color: #EF5350; -fx-border-width: 3px;"); // Red
                feedbackText.setText("Try again!");
                feedbackText.setStyle("-fx-fill: #EF5350; -fx-font-size: 24px; -fx-font-weight: bold;");
                System.out.println("Incorrect answer!");
            }
        } catch (NumberFormatException e) {
            answerField.setStyle("-fx-border-color: #EF5350; -fx-border-width: 3px;"); // Red
            feedbackText.setText("Enter a number!");
            feedbackText.setStyle("-fx-fill: #EF5350; -fx-font-size: 24px; -fx-font-weight: bold;");
            System.out.println("Invalid input!");
        }
    }

    private String getOperationText(String op) {
        switch (op) {
            case "ADDITION": return "Addition";
            case "SUBTRACTION": return "Subtraction";
            case "MULTIPLICATION": return "Multiplication";
            case "DIVISION": return "Division";
            default: return "Math";
        }
    }

    private String getOperationLabelClass(String op) {
        switch (op) {
            case "ADDITION": return "add-label";
            case "SUBTRACTION": return "subtract-label";
            case "MULTIPLICATION": return "multiply-label";
            case "DIVISION": return "divide-label";
            default: return "add-label";
        }
    }

    private String getDifficultyText(String diff) {
        switch (diff) {
            case "EASY": return "Easy";
            case "MODERATE": return "Medium";
            case "HARD": return "Hard";
            default: return "";
        }
    }

    private String getDifficultyBadgeClass(String diff) {
        switch (diff) {
            case "EASY": return "easy-badge";
            case "MODERATE": return "medium-badge";
            case "HARD": return "hard-badge";
            default: return "easy-badge";
        }
    }
} 