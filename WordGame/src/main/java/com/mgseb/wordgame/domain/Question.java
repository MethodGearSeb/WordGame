package com.mgseb.wordgame.domain;

public class Question {
    
    private final String hint;
    private final String answer;

    public Question(String hint, String answer) {
        this.hint = hint;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getHint() {
        return hint;
    }
    
    public boolean isCorrect(String guess) {
        return guess == answer;
    }
}
