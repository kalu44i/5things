package com.example.android.things;

import java.util.Map;

/**
 * Created by NickVeremeichyk on 2/27/16.
 */
public class Page {
    private String question;
    private String info;
    private Map<String, Boolean> answers;

    public Page() {
    }

    public Page(String question, String info) {
        this.question = question;
        this.info = info;
    }

    public Page(String question, String info, Map<String, Boolean> answers) {
        this.question = question;
        this.info = info;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public String getInfo() {
        return info;
    }

    public void setAnswers(Map<String, Boolean> answers) {
        this.answers = answers;
    }

    public Map<String, Boolean> getAnswers() {
        return answers;
    }
}
