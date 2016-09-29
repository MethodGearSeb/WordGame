package com.mgseb.wordgame.game;

public class GameInfo {

    private String message;
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
        } else {
            wrong++;
            message = "You the worst!";
        }
    }

    public String getMessage() {
        return message;
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
}
