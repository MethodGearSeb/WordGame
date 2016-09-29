package com.mgseb.wordgame;

import com.mgseb.wordgame.game.App;
import com.mgseb.wordgame.ui.*;

public class Main {

    public static void main(String[] args) {
        UI ui = new SwingUI();
        App app = new App(ui);
        app.run();
    }
}
