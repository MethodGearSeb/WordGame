package com.mgseb.wordgame.game;

import com.mgseb.wordgame.ui.UI;

public class App {

    private final QuestionSeries series;
    private final UI ui;

    public App(UI ui) {
        this.ui = ui;
        this.series = new QuestionSeries();
        setSeries();
    }
    
    public void run() {
        String welcomeMessage = "Welcome to Word Game! Guess the word based"
                + " on the question and partially visible answer.\n";
        System.out.println(welcomeMessage);
        String disclaimer = "NOTE: For now the game continues until ALL the "
                + "questions in the reserve are answered. This is a "
                + "temporary feature.\n";
        System.out.println(disclaimer);
        
        while (series.hasNext()) {
            
        }
    }
    
    private void setSeries() {
        QuestionReader reader = new QuestionReader(null);
        reader.readQuestions(series);
    }
}
