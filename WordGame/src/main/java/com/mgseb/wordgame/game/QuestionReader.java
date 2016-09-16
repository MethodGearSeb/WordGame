package com.mgseb.wordgame.game;

import com.mgseb.wordgame.domain.Question;
import java.util.ArrayList;
import java.util.List;

public class QuestionReader {

    private final String fileAddress;
    private final List<Question> questionList;

    public QuestionReader(String fileAddress) {
        if (!(fileAddress == null)) {
            this.fileAddress = fileAddress;
        } else {
            // replaces null argument with default file address
            this.fileAddress = "";
        }
        this.questionList = new ArrayList<>();
    }

    // picks, deletes, and returns a random question from list
    public Question next() {
        return null;
    }
}
