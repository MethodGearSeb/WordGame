package com.mgseb.wordgame.ui;

import com.mgseb.wordgame.domain.Question;
import com.mgseb.wordgame.game.Difficulty;
import java.util.Scanner;

public class ConsoleUI implements UI {
    
    private final Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }
    
    private void emptyLine() {
        System.out.println();
    }
    
    private void displayBeforeInput(String message) {
        System.out.print(message);
        System.out.print(": ");
    }

    @Override
    public String askQuestion(Question question, Difficulty difficulty) {
        displayMessage(question.getQuestion());
        displayMessage(question.getPartialAnswer(difficulty));
        emptyLine();
        displayBeforeInput("Your guess");
        
        return scanner.nextLine();
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public Difficulty selectDifficulty() {
        String options = "1: easy  2: medium  3: hard";
        
        displayMessage(options);
        emptyLine();
        displayBeforeInput("Enter number to choose difficulty");
        
        int input = Integer.parseInt(scanner.nextLine());
        
        switch (input) {
            case 1:
                return Difficulty.EASY;
            case 2:
                return Difficulty.MEDIUM;
            case 3:
                return Difficulty.HARD;
            default:
                emptyLine();
                String message = "Medium was chosen for you.";
                displayMessage(message);
                emptyLine();
                return Difficulty.MEDIUM;
        }
    }
}
