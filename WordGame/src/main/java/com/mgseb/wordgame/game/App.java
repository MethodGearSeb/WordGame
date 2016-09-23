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
        String welcomeMessage = "Welcome to Word Game! Guess the word based"
                + " on the question and partially visible answer.\n";
        String disclaimer = "NOTE: For now the game continues until ALL the "
                + "questions in the reserve are answered.\nThis is a "
                + "temporary feature.\n";

        ui.displayMessage(welcomeMessage);
        ui.displayMessage(disclaimer);
        
        Difficulty difficulty = ui.selectDifficulty();

        while (series.hasNext()) {
            Question question = series.next();
            String guess = ui.askQuestion(question, difficulty);
            String message;

            if (question.isCorrect(guess)) {
                message = "You the best!\n";
            } else {
                message = "You the worst!\n";
            }

            ui.displayMessage(message);
        }
    }

    private void setSeries() {
        QuestionReader reader = new QuestionReader(null);
        reader.readQuestions(series);
    }
}
