package com.mgseb.wordgame.game;

import com.mgseb.wordgame.domain.Question;
import com.mgseb.wordgame.game.QuestionSeries;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fuksi
 */
public class QuestionSeriesTest {
    
    QuestionSeries series;
    String question1;
    String question2;
    String question3;
    String answer1;
    String answer2;
    String answer3;
    
    public QuestionSeriesTest() {
        series = new QuestionSeries();
        question1 = "Capital city of Finland";
        question2 = "Drool";
        question3 = "Make worse";
        answer1 = "Helsinki";
        answer2 = "salivate";
        answer3 = "exacerbate";
    }
    
    @Before
    public void setUp() {
        Question question = new Question(question1, answer1);
        series.addQuestion(question);
    }
    
    @Test
    public void nextReturnsAQuestion() {
        assertEquals(Question.class, series.next().getClass());
    }
    
    @Test
    public void nextDeletesQuestion() {
        series.next();
        assertFalse(series.hasNext());
    }
    
    @Test
    public void nextReturnsNullIfNoneLeft() {
        series.next();
        assertEquals(null, series.next());
    }
    
    @Test
    public void questionListHasNoSurplus() {
        series.addQuestion(new Question(question1, answer1));
        series.addQuestion(new Question(question1, answer1));
        int i = 0;
        while (series.hasNext()) {
            series.next();
            i++;
        }
        assertEquals(3, i);
    }
    
    @Test
    public void nextReturnsAddedQuestion() {
        series.next();
        Question question = new Question(question3, answer3);
        series.addQuestion(question);
        assertEquals(question, series.next());
    }
}
