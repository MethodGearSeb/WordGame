package com.mgseb.wordgame.game;

import com.mgseb.wordgame.ui.UI;

public class App {
    
    private QuestionReader reader;
    private UI ui;

    public App(UI ui) {
        this.ui = ui;
    }
    
    public void run() {
        
        ui.run();
    }
}
