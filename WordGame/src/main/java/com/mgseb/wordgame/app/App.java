package com.mgseb.wordgame.app;

import com.mgseb.wordgame.domain.GameInfo;
import com.mgseb.wordgame.domain.Question;
import com.mgseb.wordgame.game.Difficulty;
import com.mgseb.wordgame.game.QuestionReader;
import com.mgseb.wordgame.game.QuestionSeries;
import com.mgseb.wordgame.ui.ConsoleUI;
import com.mgseb.wordgame.ui.SwingUI;
import com.mgseb.wordgame.ui.UI;

/**
 * Launches the UI. Tells Console UI what to do.
 *
 * @author fuksi
 */
public class App {

    private final UI ui;

    /**
     * Initialises attributes.
     *
     * @param ui the UI passed on from Main
     */
    public App(UI ui) {
        this.ui = ui;
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
        GameInfo info = new GameInfo();
        QuestionSeries series = new QuestionSeries();

        setSeries(series);
        cui.setInfo(info);

        while (info.getQuestionNumber() <= 10 && series.hasNext()) {
            Question question = series.next();
            String guess = cui.askQuestion(question, difficulty);

            cui.consequence(question.getAnswer(), question.isCorrect(guess));
        }

        cui.score();
        cui.gameover();
    }

    private void runSwing() {
        ui.run();
    }

    private void setSeries(QuestionSeries series) {
        QuestionReader reader = new QuestionReader(null);
        reader.readQuestions(series);
    }
}
