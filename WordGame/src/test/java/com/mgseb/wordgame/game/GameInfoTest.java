package com.mgseb.wordgame.game;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameInfoTest {
    
    private final String start;
    private final String right;
    private final String wrong;
    private GameInfo info;
    
    public GameInfoTest() {
        start = "Get started!";
        right = "You the best!";
        wrong = "You the worst!";
    }
    
    @Before
    public void setUp() {
        info = new GameInfo();
    }
    
    @Test
    public void correctStartMessage() {
        assertEquals(start, info.getMessage());
    }
    
    @Test
    public void correctMessageWhenRight() {
        info.nextQuestion(true);
        assertEquals(right, info.getMessage());
    }
    
    @Test
    public void correctMessageWhenWrong() {
        info.nextQuestion(false);
        assertEquals(wrong, info.getMessage());
    }
    
    @Test
    public void questionNumberInitializedAtOne() {
        assertEquals(1, info.getQuestionNumber());
    }
    
    @Test
    public void rightIntInitializedAtZero() {
        assertEquals(0, info.getRight());
    }
    
    @Test
    public void wrongIntInitializedAtZero() {
        assertEquals(0, info.getWrong());
    }
    
    @Test
    public void nextQuestionIncreasesQuestionNumber() {
        info.nextQuestion(true);
        assertEquals(2, info.getQuestionNumber());
    }
    
    @Test
    public void nextQuestionIncreasesRightInt() {
        info.nextQuestion(true);
        assertEquals(1, info.getRight());
    }
    
    @Test
    public void nextQuestionIncreasesWrongInt() {
        info.nextQuestion(false);
        assertEquals(1, info.getWrong());
    }
    
    @Test
    public void nextQuestionDoesntAffectRightIntWhenWrong() {
        info.nextQuestion(false);
        assertEquals(0, info.getRight());
    }
    
    @Test
    public void nextQuestionDoesntAffectWrongIntWhenRight() {
        info.nextQuestion(true);
        assertEquals(0, info.getWrong());
    }
}
