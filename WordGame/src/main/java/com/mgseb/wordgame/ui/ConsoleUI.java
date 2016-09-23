package com.mgseb.wordgame.ui;

import com.mgseb.wordgame.domain.Question;
import com.mgseb.wordgame.game.Difficulty;
import java.util.Scanner;

public class ConsoleUI implements UI {

    private final Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String askQuestion(Question question, Difficulty difficulty) {
        System.out.println(question.getQuestion());
        System.out.println(question.getPartialAnswer(difficulty));
        System.out.print("\nYour guess: ");

        return scanner.nextLine();
    }

    @Override
    public Difficulty selectDifficulty() {
        System.out.println("1: very easy  2: easy  3: medium  4: hard\n");
        System.out.print("Enter number to choose difficulty: ");

        int input = Integer.parseInt(scanner.nextLine());
        
        System.out.println();

        switch (input) {
            case 1:
                return Difficulty.BABY;
            case 2:
                return Difficulty.EASY;
            case 3:
                return Difficulty.MEDIUM;
            case 4:
                return Difficulty.HARD;
            default:
                System.out.println("\nMedium was chosen for you.\n");
                return Difficulty.MEDIUM;
        }
    }

    @Override
    public void run() {
        String welcomeMessage = "Welcome to Word Game! Guess the word based"
                + " on the question and partially visible answer.";
        String disclaimer = "NOTE: For now the game continues until ALL the "
                + "questions in the reserve are answered.\nThis is a "
                + "temporary feature.";
        System.out.println(welcomeMessage + "\n");
        System.out.println(disclaimer + "\n");
    }

    @Override
    public void consequence(boolean correctAnswer) {
        if (correctAnswer) {
            System.out.println("You the best!\n");
        } else {
            System.out.println("You the worst!\n");
        }
    }
}
