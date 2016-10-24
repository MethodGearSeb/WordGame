package com.mgseb.wordgame.domain;

import com.mgseb.wordgame.game.Difficulty;
import java.util.Random;

/**
 * Manages question-answer pairs. Conceals partial answers to varying extent.
 * Checks whether player's input matches answer.
 */
public class Question {

    private final String question;
    private final String answer;
    private String partialAnswer;

    /**
     * Sets up class variables. Partial answer is initially fully visible.
     *
     * @param question Question string read from file by QuestionReader
     * @param answer Answer string read from file by QuestionReader
     */
    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    /**
     * Returns partially conceals, then returns partial answer. Extent of
     * concealment depends on chosen game difficulty.
     *
     * @param difficulty the difficulty setting chosen by the user
     * @return partially concealed answer to serve as a hint to the user
     */
    public String getPartialAnswer(Difficulty difficulty) {
        hideLetters(difficulty);
        return partialAnswer;
    }

    /**
     * Checks whether user input matches answer. Case insensitive.
     *
     * @param guess user input
     * @return the correctness of the user's guess
     */
    public boolean isCorrect(String guess) {
        return guess.toLowerCase().equals(answer.toLowerCase());
    }

    /**
     * Partially conceals partial answer. Number of hidden letters depends on
     * chosen difficulty.
     *
     * @param difficulty the difficulty setting chosen by the user
     */
    public void hideLetters(Difficulty difficulty) {
        int hiddenLetters = numberOfHiddenLetters(difficulty);
        Random random = new Random();
        String temp = "";
        boolean showLetter;

        for (int i = 0; i < answer.length(); i++) {
            showLetter = random.nextBoolean();

            if ((showLetter || hiddenLetters == 0)
                    && hiddenLetters < answer.length() - i) {
                temp += answer.charAt(i);
            } else {
                temp += "  ";
                temp += (char) 800;
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
