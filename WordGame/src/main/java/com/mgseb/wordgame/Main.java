package com.mgseb.wordgame;

import com.mgseb.wordgame.game.App;
import com.mgseb.wordgame.ui.ConsoleUI;
import com.mgseb.wordgame.ui.UI;

public class Main {

    public static void main(String[] args) {
        UI ui = new ConsoleUI();
        App app = new App(ui);
        app.run();
    }
}
