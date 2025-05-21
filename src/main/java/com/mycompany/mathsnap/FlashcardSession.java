package com.mycompany.mathsnap;

public class FlashcardSession {
    private static FlashcardSession instance;
    private String operation;
    private String difficulty;
    private MathProblem currentProblem;

    private FlashcardSession() {}

    public static FlashcardSession getInstance() {
        if (instance == null) instance = new FlashcardSession();
        return instance;
    }

    public void setOperation(String op) { this.operation = op; }
    public void setDifficulty(String diff) { this.difficulty = diff; }
    public String getOperation() { return operation; }
    public String getDifficulty() { return difficulty; }

    public void generateNewProblem() {
        if (operation != null && difficulty != null) {
            currentProblem = MathProblem.generateRandom(operation, difficulty);
        }
    }
    public MathProblem getCurrentProblem() { return currentProblem; }
} 