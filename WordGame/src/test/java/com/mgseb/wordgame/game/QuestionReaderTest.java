package com.mgseb.wordgame.game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuestionReaderTest {

    String testfile;

    public QuestionReaderTest() {
        testfile = "wordgame/test.txt";
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void nextQuestionWorks() {
        int i = 0;
        QuestionReader reader = new QuestionReader(testfile);
        QuestionSeries series = new QuestionSeries();
        reader.readQuestions(series);

        while (series.hasNext()) {
            series.next();
            i++;
        }

        assertEquals(4, i);
    }
}
