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
                        min = 1; max = 99;
                        break;
                    case "HARD":
                        min = 10; max = 99;
                        break;
                    default:
                        min = 1; max = 9;
                }
                for (int tries = 0; tries < 100; tries++) {
                    int aMin = min, aMax = max, bMin = min, bMax = max;
                    if ("MODERATE".equals(difficulty)) {
                        // One operand 1-digit, one operand 2-digit
                        boolean oneDigitDividend = rand.nextBoolean();
                        if (oneDigitDividend) {
                            a = rand.nextInt(9) + 1; // dividend 1-digit
                            java.util.List<Integer> divisors = new java.util.ArrayList<>();
                            for (int d = 10; d <= 99; d++) {
                                if (d < a && a % d == 0) divisors.add(d);
                            }
                            if (!divisors.isEmpty()) {
                                b = divisors.get(rand.nextInt(divisors.size()));
                                answer = a / b;
                                return new MathProblem(a, b, op, answer, difficulty);
                            }
                        } else {
                            a = rand.nextInt(90) + 10; // dividend 2-digit
                            java.util.List<Integer> divisors = new java.util.ArrayList<>();
                            for (int d = 1; d <= 9; d++) {
                                if (d < a && a % d == 0) divisors.add(d);
                            }
                            if (!divisors.isEmpty()) {
                                b = divisors.get(rand.nextInt(divisors.size()));
                                answer = a / b;
                                return new MathProblem(a, b, op, answer, difficulty);
                            }
                        }
                        continue;
                    } else if ("HARD".equals(difficulty)) {
                        // Both dividend and divisor are 2-digit (10-99)
                        a = rand.nextInt(90) + 10; // dividend 2-digit
                        java.util.List<Integer> divisors = new java.util.ArrayList<>();
                        for (int d = 10; d <= 99; d++) {
                            if (d < a && a % d == 0) divisors.add(d);
                        }
                        if (!divisors.isEmpty()) {
                            b = divisors.get(rand.nextInt(divisors.size()));
                            answer = a / b;
                            return new MathProblem(a, b, op, answer, difficulty);
                        }
                        continue;
                    } else {
                        a = rand.nextInt(max - min + 1) + min;
                        b = rand.nextInt(max - min + 1) + min;
                    }
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
                        // One operand 1-digit, one operand 2-digit for all three operations
                        if (rand.nextBoolean()) {
                            a = rand.nextInt(9) + 1;
                            b = rand.nextInt(90) + 10;
                        } else {
                            a = rand.nextInt(90) + 10;
                            b = rand.nextInt(9) + 1;
                        }
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