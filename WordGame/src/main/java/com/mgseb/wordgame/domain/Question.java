package com.mgseb.wordgame.domain;

import com.mgseb.wordgame.game.Difficulty;
import java.util.Random;

public class Question {

    private final String question;
    private final String answer;
    private String partialAnswer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.partialAnswer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getPartialAnswer(Difficulty difficulty) {
        hideLetters(difficulty);
        return partialAnswer;
    }

    public boolean isCorrect(String guess) {
        return guess.toLowerCase().equals(answer.toLowerCase());
    }

    public void hideLetters(Difficulty difficulty) {
        partialAnswer = answer;
        int hiddenLetters = numberOfHiddenLetters(difficulty);
        Random random = new Random();
        String temp = "";
        boolean showLetter;

        for (int i = 0; i < partialAnswer.length(); i++) {
            showLetter = random.nextBoolean();

            if ((showLetter || hiddenLetters == 0)
                    && hiddenLetters < partialAnswer.length() - i) {
                temp += partialAnswer.charAt(i);
            } else {
                temp += (char) 1463;
                temp += " ";
                hiddenLetters--;
            }
        }

        partialAnswer = temp;
    }

    private int numberOfHiddenLetters(Difficulty difficulty) {
        int hiddenLetters = 0;

        switch (difficulty) {
            case BABY:
                hiddenLetters = answer.length() / 4;
                break;
            case EASY:
                hiddenLetters = answer.length() / 2;
                break;
            case MEDIUM:
                hiddenLetters = answer.length() / 4 * 3;
                break;
            case HARD:
                hiddenLetters = answer.length();
                break;
        }

        return hiddenLetters;
    }
}
