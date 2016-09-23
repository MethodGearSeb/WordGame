package com.mgseb.wordgame.game;

import com.mgseb.wordgame.domain.Question;
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
        ui.run();
        
        Difficulty difficulty = ui.selectDifficulty();

        while (series.hasNext()) {
            Question question = series.next();
            String guess = ui.askQuestion(question, difficulty);
            
            ui.consequence(question.isCorrect(guess));
        }
    }

    private void setSeries() {
        QuestionReader reader = new QuestionReader(null);
        reader.readQuestions(series);
    }
}
