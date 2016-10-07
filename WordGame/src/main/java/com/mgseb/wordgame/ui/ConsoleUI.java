package com.mgseb.wordgame.ui;

import com.mgseb.wordgame.domain.Question;
import com.mgseb.wordgame.game.Difficulty;
import java.util.Scanner;

/**
 * Console based UI for the application. Here as backup in the event the
 * graphical Swing UI fails.
 *
 * @author fuksi
 */
public class ConsoleUI implements UI {

    private final Scanner scanner;

    /**
     * Initialises scanner.
     */
    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays question and handles user input. A partial look at the answer
     * included.
     *
     * @param question the question to be displayed
     * @param difficulty dictates the degree of visibility of the partial answer
     * @return user's guess
     */
    public String askQuestion(Question question, Difficulty difficulty) {
        System.out.println(question.getQuestion());
        System.out.println(question.getPartialAnswer(difficulty));
        System.out.print("\nYour guess: ");

        return scanner.nextLine();
    }

    /**
     * Asks user to choose a difficulty setting. Overrules invalid input.
     *
     * @return difficulty chosen by the user
     */
    public Difficulty selectDifficulty() {
        System.out.println("1: very easy  2: easy  3: medium  4: hard\n");
        System.out.print("Enter number to choose difficulty: ");

        int input = 5;

        try {
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
        }

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
                System.out.println("Medium was chosen for you.\n");
                return Difficulty.MEDIUM;
        }
    }

    /**
     * Tells user whether or not the guess was the right answer.
     *
     * @param correctAnswer the correctness of the guess
     */
    public void consequence(boolean correctAnswer) {
        if (correctAnswer) {
            System.out.println("You the best!\n");
        } else {
            System.out.println("You the worst!\n");
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
}
