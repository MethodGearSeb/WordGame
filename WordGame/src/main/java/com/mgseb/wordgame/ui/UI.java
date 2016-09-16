package com.mgseb.wordgame.ui;

import com.mgseb.wordgame.domain.Question;

public interface UI {
    
    public void run();
    
    public String askQuestion(Question question);
}
