package com.mgseb.wordgame;

import com.mgseb.wordgame.domain.Question;
import com.mgseb.wordgame.game.App;
import com.mgseb.wordgame.game.Difficulty;
import com.mgseb.wordgame.game.QuestionReader;
import com.mgseb.wordgame.game.QuestionSeries;
import com.mgseb.wordgame.ui.ConsoleUI;
import com.mgseb.wordgame.ui.UI;

public class Main {

    public static void main(String[] args) {
        QuestionReader reader = new QuestionReader(null);
        QuestionSeries series = new QuestionSeries();
        reader.readQuestions(series);
        for (int i = 0; i < 3; i++) {
            Question question = series.next();
            System.out.println(question.getQuestion());
            question.hideLetters(Difficulty.MEDIUM);
            System.out.println(question.getVisibleAnswer());
        }
        UI ui = new ConsoleUI();
        App app = new App(reader, ui);
    }
}
