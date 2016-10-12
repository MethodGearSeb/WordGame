package com.mgseb.wordgame.ui;

import com.mgseb.wordgame.app.App;
import com.mgseb.wordgame.domain.GameInfo;
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
    private GameInfo info;

    /**
     * Initialises scanner.
     */
    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    public void setInfo(GameInfo info) {
        this.info = info;
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
        if (info == null) {
            System.out.println("ERROR: Info has not been set");
        }

        System.out.println("Question " + info.getQuestionNumber() + "/10");
        System.out.println("right: " + info.getRight());
        System.out.println("wrong: " + info.getWrong() + "\n");
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
     * @param answer correct answer in String form for printing
     * @param correctAnswer the correctness of the guess
     */
    public void consequence(String answer, boolean correctAnswer) {
        info.nextQuestion(correctAnswer);
        System.out.println("Correct answer: " + answer
                + "\n\n" + info.getMessage() + "\n");
    }

    /**
     * Displays user's overall score once game is over.
     */
    public void score() {
        System.out.println("You got " + info.getRight() + " out of 10 right");
        System.out.println();
    }

    /**
     * Determines whether to start a new game. Does so through user input.
     */
    public void gameover() {
        System.out.print("New game? (y/n): ");

        String newGame = scanner.nextLine().toLowerCase();

        switch (newGame) {
            case "y":
                System.out.println();
                new App(new ConsoleUI()).run();
                break;
            case "n":
                break;
            default:
                gameover();
                break;
        }
    }

    @Override
    public void run() {
        String welcomeMessage = "Welcome to Word Game! Guess the word based"
                + " on the question and partially visible answer.";
        System.out.println(welcomeMessage + "\n");
    }
}
