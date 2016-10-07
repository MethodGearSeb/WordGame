package com.mgseb.wordgame.ui;

import com.mgseb.wordgame.domain.Question;
import com.mgseb.wordgame.game.Difficulty;
import com.mgseb.wordgame.game.GameInfo;
import com.mgseb.wordgame.game.QuestionReader;
import com.mgseb.wordgame.game.QuestionSeries;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SwingUI extends JFrame implements UI, ActionListener {

    private QuestionSeries series;
    private Difficulty difficulty;
    private GameInfo info;
    private Question question;

    private void difficultySelectionView() {
        Container p = getContentPane();
        series = null;
        difficulty = null;
        info = null;
        question = null;
        String[] options = {
            "Very easy",
            "Easy",
            "Medium",
            "Hard"
        };
        GridLayout layout = new GridLayout(2, 2);
        JLabel label = new JLabel("Select difficulty");
        JComboBox combox = new JComboBox(options);
        JButton button = new JButton("Start game");

        p.removeAll();
        combox.setSelectedIndex(2);
        button.setActionCommand("start");
        button.addActionListener(this);
        p.setLayout(layout);
        p.add(label);
        p.add(new JPanel());
        p.add(combox);
        p.add(button);
        pack();
        this.getRootPane().setDefaultButton(button);
    }

    private void gameView() {
        Container p = getContentPane();
        question = series.next();
        String round = "Question " + info.getQuestionNumber() + "/10";
        String right = "Right: " + info.getRight();
        String wrong = "Wrong: " + info.getWrong();
        JTextArea questionText = new JTextArea(question.getQuestion());
        JTextArea partial = new JTextArea(question.getPartialAnswer(difficulty));
        JTextField guess = new JTextField();
        JPanel infoPanel = new JPanel();
        JTextPane message = new JTextPane();
        JPanel buttonPanel = new JPanel();
        JButton answer = new JButton("Answer");
        JButton quit = new JButton("Quit");
        GridLayout layout = new GridLayout(3, 2);
        GridLayout infoLayout = new GridLayout(4, 1);
        GridLayout buttonLayout = new GridLayout(2, 1);

        p.removeAll();
        p.setLayout(layout);
        infoPanel.setLayout(infoLayout);
        message.setText(info.getMessage());
        buttonPanel.setLayout(buttonLayout);
        infoPanel.add(new JTextArea(round));
        infoPanel.add(new JTextArea(right));
        infoPanel.add(new JTextArea(wrong));
        infoPanel.add(new JPanel());
        answer.setActionCommand("answer");
        answer.addActionListener(this);
        quit.setActionCommand("quit");
        quit.addActionListener(this);
        buttonPanel.add(answer);
        buttonPanel.add(quit);
        p.add(questionText);
        p.add(infoPanel);
        p.add(partial);
        p.add(message);
        p.add(guess);
        p.add(buttonPanel);
        pack();
        p.getComponent(4).requestFocus();
        this.getRootPane().setDefaultButton(answer);
    }

    private void gameoverView() {
        Container p = getContentPane();
        String messageText = "You got " + info.getRight() + " out of 10 right";
        JLabel message = new JLabel(messageText);
        JButton newGame = new JButton("Start a new game");
        JButton difficultyButton = new JButton("Change difficulty");
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(2, 1);
        GridLayout buttonLayout = new GridLayout(1, 2);
        
        p.removeAll();
        p.setLayout(layout);
        newGame.setActionCommand("start new");
        newGame.addActionListener(this);
        difficultyButton.setActionCommand("quit");
        difficultyButton.addActionListener(this);
        panel.setLayout(buttonLayout);
        panel.add(newGame);
        panel.add(difficultyButton);
        p.add(message);
        p.add(panel);
        pack();
        this.getRootPane().setDefaultButton(newGame);
    }

    private void setSeries() {
        series = new QuestionSeries();
        QuestionReader reader = new QuestionReader(null);
        reader.readQuestions(series);
    }

    private void selectDifficulty(Container p) {
        JComboBox combox = (JComboBox) p.getComponent(2);
        int input = combox.getSelectedIndex();

        switch (input) {
            case 0:
                difficulty = Difficulty.BABY;
                break;
            case 1:
                difficulty = Difficulty.EASY;
                break;
            case 2:
                difficulty = Difficulty.MEDIUM;
                break;
            case 3:
                difficulty = Difficulty.HARD;
                break;
        }

        startGame();
    }
    
    private void startGame() {
        setSeries();

        if (series.hasNext()) {
            info = new GameInfo();

            gameView();
        }
    }

    private void answer(Container p) {
        JTextField guess = (JTextField) p.getComponent(4);
        boolean correct = question.isCorrect(guess.getText());

        info.nextQuestion(correct);

        JPanel buttonPanel = (JPanel) p.getComponent(5);
        JButton next = (JButton) buttonPanel.getComponent(0);

        next.setText("Next");
        next.setActionCommand("next");
        updateGameView(p);
    }

    private void nextQuestion() {
        if (series.hasNext() && info.getQuestionNumber() <= 10) {
            gameView();
        } else {
            gameoverView();
        }
    }

    private void updateGameView(Container p) {
        JPanel infoPanel = (JPanel) p.getComponent(1);
        JTextArea partial = (JTextArea) p.getComponent(2);
        JTextPane message = (JTextPane) p.getComponent(3);
        JTextArea rightArea = (JTextArea) infoPanel.getComponent(1);
        JTextArea wrongArea = (JTextArea) infoPanel.getComponent(2);
        String right = "Right: " + info.getRight();
        String wrong = "Wrong: " + info.getWrong();

        rightArea.setText(right);
        wrongArea.setText(wrong);
        partial.setText(question.getAnswer());
        message.setForeground(info.getMessageColor());
        message.setText(info.getMessage());
    }

    @Override
    public void run() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        difficultySelectionView();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Container p = getContentPane();

        switch (command) {
            case "start":
                selectDifficulty(p);
                break;
            case "start new":
                startGame();
                break;
            case "quit":
                difficultySelectionView();
                break;
            case "answer":
                answer(p);
                break;
            case "next":
                info.defaultMessage();
                nextQuestion();
                break;
        }
    }
}
