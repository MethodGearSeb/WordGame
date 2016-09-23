package com.mgseb.wordgame.ui;

import com.mgseb.wordgame.domain.Question;
import com.mgseb.wordgame.game.Difficulty;

public interface UI {
    
    public Difficulty selectDifficulty();
    
    public String askQuestion(Question question, Difficulty difficulty);
    
    public void consequence(boolean correctAnswer);
    
    public void run();
}
