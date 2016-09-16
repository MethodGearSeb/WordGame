package com.mgseb.wordgame.domain;

import junit.framework.Assert;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertFalse;
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
        assertTrue(question.isCorrect(answer));
    }
    
    @Test
    public void isCorrectCanReturnFalse() {
        assertFalse(question.isCorrect(hint));
    }
    
    @Test
    public void isCorrectIsCaseInsensitive() {
        assertTrue(question.isCorrect(answer.toUpperCase()));
    }
}
