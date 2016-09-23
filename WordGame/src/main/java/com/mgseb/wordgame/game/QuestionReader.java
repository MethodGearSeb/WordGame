package com.mgseb.wordgame.game;

import com.mgseb.wordgame.domain.Question;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuestionReader {

    private final String fileAddress;

    /**
     * If file address given is null, use default file address.
     *
     * @param fileAddress
     */
    public QuestionReader(String fileAddress) {
        this.fileAddress = replaceIfInvalid(fileAddress);
    }

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
                
                while (!line.contains("#")) {
                    line = scanner.nextLine();
                    hint += line;
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
        if (fileAddress != null) {
            if (!fileAddress.isEmpty()) {
                return fileAddress;
            }
        }
        return "recourses/wordgame/english.txt";
    }

    private Scanner openScanner() {
        File file = new File(fileAddress);
        Scanner scanner = null;
        System.out.println("text1");
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File could not be found");
        }
        return scanner;
    }
}
