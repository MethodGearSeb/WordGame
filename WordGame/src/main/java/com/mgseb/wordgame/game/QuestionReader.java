package com.mgseb.wordgame.game;

import com.mgseb.wordgame.domain.Question;
import java.util.ArrayList;
import java.util.List;

public class QuestionReader {
    
    private final String fileAddress;
    private final List<Question> questionList;

    public QuestionReader(String fileAddress) {
        this.fileAddress = fileAddress;
        this.questionList = new ArrayList<>();
    }
    
    public Question next() {
        return null;
    }
}
