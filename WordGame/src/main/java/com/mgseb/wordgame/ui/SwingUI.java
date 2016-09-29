package com.mgseb.wordgame.ui;

import com.mgseb.wordgame.domain.Question;
import com.mgseb.wordgame.game.Difficulty;
import com.mgseb.wordgame.game.GameInfo;
import com.mgseb.wordgame.game.QuestionReader;
import com.mgseb.wordgame.game.QuestionSeries;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class SwingUI extends JFrame implements UI, ActionListener, 
        KeyListener {

    private QuestionSeries series;
    private Difficulty difficulty;
    private GameInfo info;
    private Question question;
    private String view;

    private void difficultySelectionView() {
        Container p = getContentPane();
        view = "difficulty";
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
        p.addKeyListener(this);
    }

    private void gameView() {
        Container p = getContentPane();
        view = "game";
        question = series.next();
        String round = "Question " + info.getQuestionNumber();
        String right = "Right: " + info.getRight();
        String wrong = "Wrong: " + info.getWrong();
        JTextArea questionText = new JTextArea(question.getQuestion());
        JTextArea partial = new JTextArea(question.getPartialAnswer(difficulty));
        JTextField guess = new JTextField();
        JPanel infoPanel = new JPanel();
        JTextArea message = new JTextArea(info.getMessage());
        JPanel buttonPanel = new JPanel();
        JButton answer = new JButton("Answer");
        JButton quit = new JButton("Quit");
        GridLayout layout = new GridLayout(3, 2);
        GridLayout infoLayout = new GridLayout(4, 1);
        GridLayout buttonLayout = new GridLayout(2, 1);

        p.removeAll();
        p.setLayout(layout);
        infoPanel.setLayout(infoLayout);
        buttonPanel.setLayout(buttonLayout);
        infoPanel.add(new JTextArea(round));
        infoPanel.add(new JTextArea(right));
        infoPanel.add(new JTextArea(wrong));
        infoPanel.add(new JPanel());
        answer.setActionCommand("answer");
        answer.addActionListener(this);
        answer.addKeyListener(this);
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
        p.addKeyListener(this);
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

        setSeries();

        if (series.hasNext()) {
            info = new GameInfo();

            gameView();
        }
    }

    private void answer(Container p) {
        if (series.hasNext()) {
            JTextField guess = (JTextField) p.getComponent(4);
            boolean correct = question.isCorrect(guess.getText());

            info.nextQuestion(correct);
            gameView();
        } else {
            difficultySelectionView();
        }
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
            case "quit":
                difficultySelectionView();
                break;
            case "answer":
                answer(p);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int code = e.getKeyCode();System.out.println(code);
        Container p = getContentPane();

        switch (code) {
            case 13:
                switch (view) {
                    case "difficulty":
                        selectDifficulty(p);
                        break;
                    case "game":
                        answer(p);
                        break;
                }
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();System.out.println(code);
        Container p = getContentPane();

        switch (code) {
            case 13:
                switch (view) {
                    case "difficulty":
                        selectDifficulty(p);
                        break;
                    case "game":
                        answer(p);
                        break;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();System.out.println(code);
        Container p = getContentPane();

        switch (code) {
            case 13:
                switch (view) {
                    case "difficulty":
                        selectDifficulty(p);
                        break;
                    case "game":
                        answer(p);
                        break;
                }
                break;
        }
    }
}
