package com.mgseb.wordgame.domain;

import com.mgseb.wordgame.game.Difficulty;
import java.util.Random;

public class Question {

    private final String question;
    private final String answer;
    private String visibleAnswer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.visibleAnswer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getVisibleAnswer() {
        return visibleAnswer;
    }

    public boolean isCorrect(String guess) {
        return guess.toLowerCase().equals(answer.toLowerCase());
    }

    public void hideLetters(Difficulty difficulty) {
        visibleAnswer = answer;
        int hiddenLetters = numberOfHiddenLetters(difficulty);
        Random random = new Random();
        String temp = "";
        boolean showLetter;
        for (int i = 0; i < visibleAnswer.length(); i++) {
            showLetter = random.nextBoolean();
            if ((showLetter || hiddenLetters == 0)
                    && hiddenLetters < visibleAnswer.length() - i) {
                temp += visibleAnswer.charAt(i);
            } else {
                temp += '_';
                hiddenLetters--;
            }
        }
        visibleAnswer = temp;
    }
    
    private int numberOfHiddenLetters(Difficulty difficulty) {
        int hiddenLetters = 0;
        switch (difficulty) {
            case EASY:
                hiddenLetters = answer.length() / 2;
                break;
            case MEDIUM:
                hiddenLetters = answer.length() / 4 * 3;
                break;
            case HARD:
                hiddenLetters = answer.length();
                break;
            default:
                break;
        }
        return hiddenLetters;
    }
}
