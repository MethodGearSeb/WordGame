package com.mgseb.wordgame.game;

import com.mgseb.wordgame.domain.Question;
import java.util.ArrayList;

/**
 * Collection of questions.
 *
 * @author fuksi
 */
public class QuestionSeries {

    private final ArrayList<Question> questionList;

    /**
     * Initialises attribute.
     */
    public QuestionSeries() {
        this.questionList = new ArrayList<>();
    }

    /**
     * Adds question to the collection.
     *
     * @param question to be added
     */
    public void addQuestion(Question question) {
        questionList.add(question);
    }

    /**
     * Picks a random question from the list, deletes it, and returns it.
     *
     * @return a question for examination
     */
    public Question next() {
        if (questionList.isEmpty()) {
            return null;
        }

        int i = (int) Math.floor(Math.random() * questionList.size());
        Question question = questionList.get(i);
        questionList.remove(question);
        return question;
    }

    /**
     * Checks to see that the collection is not depleted. Meant to prevent
     * problems derived from the absence of questions.
     *
     * @return the information of whether there are questions left
     */
    public boolean hasNext() {
        return questionList.size() > 0;
    }
}
