package com.mgseb.wordgame.game;

import java.awt.Color;

public class GameInfo {

    private String message;
    private Color messageColor;
    private int questionNumber;
    private int right;
    private int wrong;

    public GameInfo() {
        message = "Get started!";
        questionNumber = 1;
        right = 0;
        wrong = 0;
    }

    public void nextQuestion(boolean correct) {
        questionNumber++;

        if (correct) {
            right++;
            message = "You the best!";
            messageColor = Color.GREEN;
        } else {
            wrong++;
            message = "You the worst!";
            messageColor = Color.RED;
        }
    }

    public String getMessage() {
        return message;
    }

    public Color getMessageColor() {
        return messageColor;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public int getRight() {
        return right;
    }

    public int getWrong() {
        return wrong;
    }
    
    public void defaultMessage() {
        message = "Guess the word.";
        messageColor = Color.BLACK;
    }
}
