package com.mgseb.wordgame.domain;

import com.mgseb.wordgame.game.Difficulty;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class QuestionTest {

    private Question question1;
    private Question question2;
    private final String hint1;
    private final String hint2;
    private final String answer1;
    private final String answer2;

    public QuestionTest() {
        this.hint1 = "The favorite fruit of a monkey.";
        this.hint2 = "Synonymous with \"tyrannical.\"";
        this.answer1 = "Banana";
        this.answer2 = "Despotic";
    }

    @Before
    public void setUp() {
        this.question1 = new Question(hint1, answer1);
        this.question2 = new Question(hint2, answer2);
    }

    @Test
    public void getHint() {
        assertEquals(hint1,
                question1.getQuestion());
    }

    @Test
    public void isCorrect() {
        assertTrue(question1.isCorrect(answer1));
    }

    @Test
    public void isCorrectCanReturnFalse() {
        assertFalse(question1.isCorrect(answer2));
    }

    @Test
    public void isCorrectIsCaseInsensitive() {
        assertTrue(question1.isCorrect(answer1.toUpperCase()));
    }

    @Test
    public void hideVisibleAnswerEasy() {
        String visibleAnswer = question2.getPartialAnswer(Difficulty.EASY);
        int expected = visibleAnswer.length() / 2;
        assertTrue(correctNumberOfUnderscores(expected, visibleAnswer));
    }

    @Test
    public void hideLettersMedium() {
        question2.hideLetters(Difficulty.MEDIUM);
        String visibleAnswer = question2.getPartialAnswer(Difficulty.MEDIUM);
        int expected = visibleAnswer.length() / 4 * 3;
        assertTrue(correctNumberOfUnderscores(expected, visibleAnswer));
    }

    @Test
    public void hideLettersHard() {
        question2.hideLetters(Difficulty.HARD);
        String visibleAnswer = question2.getPartialAnswer(Difficulty.HARD);
        int expected = visibleAnswer.length();
        assertTrue(correctNumberOfUnderscores(expected, visibleAnswer));
    }
    
    @Test
    public void hideLettersRepeatedUseHasNoEffect() {
        question2.getPartialAnswer(Difficulty.EASY);
        String visibleAnswer = question2.getPartialAnswer(Difficulty.EASY);
        int expected = visibleAnswer.length() / 2;
        assertTrue(correctNumberOfUnderscores(expected, visibleAnswer));
    }

    private boolean correctNumberOfUnderscores(int expected, String visibleAnswer) {
        int underscores = 0;
        for (char c : visibleAnswer.toCharArray()) {
            if (c == '_') {
                underscores++;
            }
        }
        return underscores == expected;
    }
}
