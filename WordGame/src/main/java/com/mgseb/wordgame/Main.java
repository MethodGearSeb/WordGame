package com.mgseb.wordgame;

import com.mgseb.wordgame.game.App;
import com.mgseb.wordgame.game.QuestionReader;
import com.mgseb.wordgame.ui.ConsoleUI;
import com.mgseb.wordgame.ui.UI;

public class Main {

    public static void main(String[] args) {
        QuestionReader reader = new QuestionReader(null);
        UI ui = new ConsoleUI();
        App app = new App(reader, ui);
    }
}
