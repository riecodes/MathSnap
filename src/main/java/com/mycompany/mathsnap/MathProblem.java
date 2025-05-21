package com.mycompany.mathsnap;

import java.util.Random;

public class MathProblem {
    private final int operand1;
    private final int operand2;
    private final String operator;
    private final int correctAnswer;
    private final String difficulty;

    public MathProblem(int operand1, int operand2, String operator, int correctAnswer, String difficulty) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;
    }

    public int getOperand1() { return operand1; }
    public int getOperand2() { return operand2; }
    public String getOperator() { return operator; }
    public int getCorrectAnswer() { return correctAnswer; }
    public String getDifficulty() { return difficulty; }

    public static MathProblem generateRandom(String operation, String difficulty) {
        Random rand = new Random();
        int min1 = 1, max1 = 9, min2 = 1, max2 = 9;
        switch (difficulty) {
            case "EASY":
                min1 = min2 = 1; max1 = max2 = 9;
                break;
            case "MODERATE":
                min1 = 1; max1 = 99; min2 = 1; max2 = 99;
                break;
            case "HARD":
                min1 = min2 = 10; max1 = max2 = 99;
                break;
        }
        int a = rand.nextInt(max1 - min1 + 1) + min1;
        int b = rand.nextInt(max2 - min2 + 1) + min2;
        String op;
        int answer;
        switch (operation) {
            case "ADDITION":
                op = "+"; answer = a + b; break;
            case "SUBTRACTION":
                op = "-"; answer = a - b; break;
            case "MULTIPLICATION":
                op = "×"; answer = a * b; break;
            case "DIVISION":
                op = "÷";
                // Ensure no division by zero and integer result
                b = rand.nextInt(max2 - min2 + 1) + min2;
                answer = rand.nextInt(max1 - min1 + 1) + min1;
                a = answer * b;
                break;
            default:
                op = "+"; answer = a + b;
        }
        return new MathProblem(a, b, op, answer, difficulty);
    }
} 