package com.mgseb.wordgame.domain;

import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class QuestionTest {

    private Question question;
    private final String hint;
    private final String answer;

    public QuestionTest() {
        this.hint = "The favorite fruit of a monkey.";
        this.answer = "Banana";
    }

    @Before
    public void setUp() {
        this.question = new Question(hint, answer);
    }

    @Test
    public void getHint() {
        assertEquals(hint,
                question.getHint());
    }

    @Test
    public void getAnswer() {
        assertEquals(answer, question.getAnswer());
    }

    @Test
    public void isCorrect() {
        assertEquals(true, question.isCorrect(answer));
    }
}
