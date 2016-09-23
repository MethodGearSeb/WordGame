package com.mgseb.wordgame.ui;

import com.mgseb.wordgame.domain.Question;

public interface UI {
    
    public void run();
    
    public void askQuestion(Question question);
}
