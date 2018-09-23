package com.zy.designs.interpreter;

public class PlayContext {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isFinished() {
        return !(text.length() > 0);
    }
}
