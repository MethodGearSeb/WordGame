package com.mgseb.wordgame.game;

import com.mgseb.wordgame.domain.Question;
import java.util.ArrayList;

public class QuestionSeries {

    private final ArrayList<Question> questionList;

    public QuestionSeries() {
        this.questionList = new ArrayList<>();
    }
    
    public void addQuestion(Question question) {
        questionList.add(question);
    }

    /**
     * Method picks a random question from the list, deletes it, and returns it.
     *
     * @return
     */
    public Question next() {
        return null;
    }
}
