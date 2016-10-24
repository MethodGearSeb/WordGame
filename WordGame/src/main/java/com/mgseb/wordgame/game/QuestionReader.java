package com.mgseb.wordgame.game;

import com.mgseb.wordgame.domain.Question;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Generates questions by scanning a text file. Feeds questions to Question
 * Series.
 *
 * @author fuksi
 */
public class QuestionReader {

    private final String fileAddress;

    /**
     * If file address given is null, use default file address.
     *
     * @param fileAddress redundant in the current state of the application
     */
    public QuestionReader(String fileAddress) {
        this.fileAddress = replaceIfInvalid(fileAddress);
    }

    /**
     * Converts data scanned from a text file into instances of class question.
     * Feeds generated questions to an instance of Question Series.
     *
     * @param series collects generated questions to be used in the game
     */
    public void readQuestions(QuestionSeries series) {
        Scanner scanner = openScanner();

        if (scanner == null) {
            return;
        }

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String hint = "";
            String answer = "";

            if (line.contains("@")) {
                hint = "";
                line = scanner.nextLine();

                while (!line.contains("#")) {
                    hint += line;
                    line = scanner.nextLine();
                }
            }

            if (line.contains("#")) {
                line = scanner.nextLine();
                answer = line;
            }

            Question question = new Question(hint, answer);
            series.addQuestion(question);
        }
    }

    private String replaceIfInvalid(String fileAddress) {
        if (fileAddress != null && !fileAddress.isEmpty()) {
            return fileAddress;
        }
        return "english.txt";
    }

    private Scanner openScanner() {
        InputStream file = getClass().getResourceAsStream(fileAddress); 
        return new Scanner(file);
    }
}
