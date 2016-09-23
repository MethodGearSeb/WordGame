package com.mgseb.wordgame.game;

public class QuestionReader {

    private final String fileAddress;

    /**
     * If file address given is null, use default file address.
     *
     * @param fileAddress
     */
    public QuestionReader(String fileAddress) {
        this.fileAddress = replaceIfInvalid(fileAddress);
    }

    private String replaceIfInvalid(String fileAddress) {
        if (fileAddress != null) {
            if (!fileAddress.isEmpty()) {
                return fileAddress;
            }
        }
        return ""; // TODO: Add default fileAddress
    }
}
