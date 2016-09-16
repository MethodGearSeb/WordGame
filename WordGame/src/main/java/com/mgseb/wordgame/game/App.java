package com.mgseb.wordgame.game;

import com.mgseb.wordgame.ui.UI;

public class App {

    private final QuestionReader reader;
    private final UI ui;

    public App(QuestionReader reader, UI ui) {
        this.reader = reader;
        this.ui = ui;
    }

    public void run() {
        ui.run();
    }
}
