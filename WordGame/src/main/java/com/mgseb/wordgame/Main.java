package com.mgseb.wordgame;

import com.mgseb.wordgame.game.App;
import com.mgseb.wordgame.game.QuestionReader;
import com.mgseb.wordgame.game.QuestionSeries;
import com.mgseb.wordgame.ui.ConsoleUI;
import com.mgseb.wordgame.ui.UI;

public class Main {

    public static void main(String[] args) {
        System.out.println("test0");
        QuestionReader reader = new QuestionReader(null);
        QuestionSeries series = new QuestionSeries();
        System.out.println("test0");
        reader.readQuestions(series);
        for (int i = 0; i < 3; i++) {
            System.out.println(series.next());
        }
        UI ui = new ConsoleUI();
        App app = new App(reader, ui);
    }
}
