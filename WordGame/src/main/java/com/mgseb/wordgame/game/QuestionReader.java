package com.mgseb.wordgame.game;

import com.mgseb.wordgame.domain.Question;
import java.util.ArrayList;

public class QuestionReader {

    private final String fileAddress;
    private final ArrayList<Question> questionList;

    /**
     * If file address given is null, use default file address.
     * @param fileAddress 
     */
    public QuestionReader(String fileAddress) {
        if (fileAddress != null || !fileAddress.isEmpty()) {
            this.fileAddress = fileAddress;
        } else {
            this.fileAddress = ""; // TODO: Add default fileAddress
        }
        this.questionList = new ArrayList<>();
    }

    /**
     * Method picks a random question from the list,
     * deletes it, and returns it.
     * @return 
     */
    public Question next() {
        return null;
    }
}
