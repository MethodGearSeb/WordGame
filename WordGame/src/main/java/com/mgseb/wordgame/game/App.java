package com.mgseb.wordgame.game;

import com.mgseb.wordgame.domain.Question;
import com.mgseb.wordgame.ui.ConsoleUI;
import com.mgseb.wordgame.ui.SwingUI;
import com.mgseb.wordgame.ui.UI;

/**
 * Launches the UI. Tells Console UI what to do.
 *
 * @author fuksi
 */
public class App {

    private final QuestionSeries series;
    private final UI ui;

    /**
     * Initialises attributes.
     *
     * @param ui the UI passed on from Main
     */
    public App(UI ui) {
        this.ui = ui;
        this.series = new QuestionSeries();
        setSeries();
    }

    /**
     * Discerns whether the UI is Swing or console based. Calls respective
     * private function to properly run the UI.
     */
    public void run() {
        Class uiClass = ui.getClass();

        if (uiClass == ConsoleUI.class) {
            runConsole();
        }

        if (uiClass == SwingUI.class) {
            runSwing();
        }
    }

    private void runConsole() {
        ui.run();

        ConsoleUI cui = (ConsoleUI) ui;
        Difficulty difficulty = cui.selectDifficulty();

        while (series.hasNext()) {
            Question question = series.next();
            String guess = cui.askQuestion(question, difficulty);

            cui.consequence(question.isCorrect(guess));
        }
    }

    private void runSwing() {
        ui.run();
    }

    private void setSeries() {
        QuestionReader reader = new QuestionReader(null);
        reader.readQuestions(series);
    }
}
