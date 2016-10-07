package com.mgseb.wordgame.domain;

import java.awt.Color;

/**
 * Keeps track of game progress and score. Manages messages that are displayed
 * to the user.
 *
 * @author fuksi
 */
public class GameInfo {

    private String message;
    private Color messageColor;
    private int questionNumber;
    private int right;
    private int wrong;

    /**
     * Initialises most class attributes.
     */
    public GameInfo() {
        message = "Get started!";
        questionNumber = 1;
        right = 0;
        wrong = 0;
    }

    /**
     * Updates game progress information. Called anytime a question is answered.
     * Updates question number, score, message, message colour.
     *
     * @param correct tells whether the latest guess made by the user was right
     */
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

    /**
     * Reverts the attributes related to the message back to neutral.
     */
    public void defaultMessage() {
        message = "Guess the word.";
        messageColor = Color.BLACK;
    }
}
