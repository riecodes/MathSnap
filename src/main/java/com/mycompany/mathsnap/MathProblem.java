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
        int a = 1, b = 1;
        String op;
        int answer;
        switch (operation) {
            case "DIVISION":
                op = "÷";
                int min, max;
                switch (difficulty) {
                    case "EASY":
                        min = 1; max = 9;
                        break;
                    case "MODERATE":
                        // 1-2 digit combo: each operand randomly 1-9 or 10-99
                        // We'll handle this below
                        min = 1; max = 99;
                        break;
                    case "HARD":
                        // 1-3 digit combo: each operand randomly 1-9, 10-99, or 100-999
                        // We'll handle this below
                        min = 1; max = 999;
                        break;
                    default:
                        min = 1; max = 9;
                }
                for (int tries = 0; tries < 100; tries++) {
                    // For MODERATE and HARD, pick dividend and divisor ranges per combo rules
                    int aMin = min, aMax = max, bMin = min, bMax = max;
                    if ("MODERATE".equals(difficulty)) {
                        aMin = bMin = 1; aMax = bMax = 99;
                        a = rand.nextBoolean() ? (rand.nextInt(9) + 1) : (rand.nextInt(90) + 10);
                        b = rand.nextBoolean() ? (rand.nextInt(9) + 1) : (rand.nextInt(90) + 10);
                    } else if ("HARD".equals(difficulty)) {
                        int[] ranges = {9, 99, 999};
                        int aRange = rand.nextInt(3), bRange = rand.nextInt(3);
                        aMin = (aRange == 0) ? 1 : (aRange == 1) ? 10 : 100;
                        aMax = ranges[aRange];
                        bMin = (bRange == 0) ? 1 : (bRange == 1) ? 10 : 100;
                        bMax = ranges[bRange];
                        a = rand.nextInt(aMax - aMin + 1) + aMin;
                        b = rand.nextInt(bMax - bMin + 1) + bMin;
                    } else {
                        a = rand.nextInt(max - min + 1) + min;
                        b = rand.nextInt(max - min + 1) + min;
                    }
                    // Find all divisors in range
                    java.util.List<Integer> divisors = new java.util.ArrayList<>();
                    for (int d = bMin; d <= bMax; d++) {
                        if (d < a && a % d == 0) divisors.add(d);
                    }
                    if (!divisors.isEmpty()) {
                        b = divisors.get(rand.nextInt(divisors.size()));
                        answer = a / b;
                        return new MathProblem(a, b, op, answer, difficulty);
                    }
                }
                // Fallback: just use 1 and 1
                a = b = 1; answer = 1;
                return new MathProblem(a, b, op, answer, difficulty);
            default:
                // Addition, Subtraction, Multiplication
                switch (difficulty) {
                    case "EASY":
                        a = rand.nextInt(9) + 1;
                        b = rand.nextInt(9) + 1;
                        break;
                    case "MODERATE":
                        a = (rand.nextBoolean() ? (rand.nextInt(9) + 1) : (rand.nextInt(90) + 10));
                        b = (rand.nextBoolean() ? (rand.nextInt(9) + 1) : (rand.nextInt(90) + 10));
                        break;
                    case "HARD":
                        a = rand.nextInt(90) + 10;
                        b = rand.nextInt(90) + 10;
                        break;
                }
                switch (operation) {
                    case "ADDITION":
                        op = "+"; answer = a + b; break;
                    case "SUBTRACTION":
                        op = "-"; answer = a - b; break;
                    case "MULTIPLICATION":
                        op = "×"; answer = a * b; break;
                    default:
                        op = "+"; answer = a + b;
                }
                return new MathProblem(a, b, op, answer, difficulty);
        }
    }
} 