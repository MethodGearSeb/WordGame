package com.mgseb.wordgame.domain;

import com.mgseb.wordgame.game.Difficulty;
import java.util.Random;

public class Question {

    private final String hint;
    private final String answer;
    private String visibleAnswer;

    public Question(String hint, String answer) {
        this.hint = hint;
        this.answer = answer;
        this.visibleAnswer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getHint() {
        return hint;
    }

    public boolean isCorrect(String guess) {
        return guess.toLowerCase().equals(answer.toLowerCase());
    }

    public void hideVisibleAnswer(Difficulty difficulty) {
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
        Random random = new Random();
        String temp = "";
        boolean showLetter;
        for (int i = 0; i < visibleAnswer.length(); i++) {
            showLetter = random.nextBoolean();
            if (hiddenLetters > 0) {
                if (showLetter) {
                    temp += visibleAnswer.charAt(i);
                    hiddenLetters--;
                } else {
                    temp += '_';
                }
            }
        }
        visibleAnswer = temp;
    }
}
