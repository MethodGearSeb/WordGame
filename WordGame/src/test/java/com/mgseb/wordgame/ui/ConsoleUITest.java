package com.mgseb.wordgame.ui;

import com.mgseb.wordgame.domain.Question;
import com.mgseb.wordgame.game.Difficulty;
import java.io.ByteArrayInputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConsoleUITest {

    ConsoleUI ui;
    String question1;
    String answer1;

    public ConsoleUITest() {
        ui = new ConsoleUI();
        question1 = "Hirvein asia ikinä";
        answer1 = "Sun äiti";
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        System.setIn(System.in);
    }

    @Test
    public void askQuestionReturnsWantedAnswer() {
        Question question = new Question(question1, answer1);

        ByteArrayInputStream in = new ByteArrayInputStream(answer1.getBytes());
        System.setIn(in);

        String vastaus = ui.askQuestion(question, Difficulty.BABY);
        assertEquals(answer1, vastaus);
    }

    @Test
    public void selectedDifficultyWorks() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes()); // BABY
        System.setIn(in);

        Difficulty testaus1 = ui.selectDifficulty();

        in = new ByteArrayInputStream("2".getBytes()); // EASY
        System.setIn(in);

        Difficulty testaus2 = ui.selectDifficulty();

        in = new ByteArrayInputStream("3".getBytes()); // MEDIUM
        System.setIn(in);

        Difficulty testaus3 = ui.selectDifficulty();

        in = new ByteArrayInputStream("4".getBytes()); // HARD
        System.setIn(in);

        Difficulty testaus4 = ui.selectDifficulty();

        assertEquals(Difficulty.BABY, testaus1);
        assertEquals(Difficulty.EASY, testaus2);
        assertEquals(Difficulty.MEDIUM, testaus3);
        assertEquals(Difficulty.HARD, testaus4);
    }
}
