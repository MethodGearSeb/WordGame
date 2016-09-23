package com.mgseb.wordgame.ui;

import com.mgseb.wordgame.domain.Question;
import com.mgseb.wordgame.game.Difficulty;

public interface UI {
    
    public String askQuestion(Question question, Difficulty difficulty);
    
    public Difficulty selectDifficulty();
    
    public void displayMessage(String message);
}
