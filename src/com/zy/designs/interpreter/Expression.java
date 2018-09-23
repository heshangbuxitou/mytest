package com.zy.designs.interpreter;

public abstract class Expression {
    public void interpret(PlayContext context) {
        String playKey = context.getText().substring(0, 1);
        context.setText(context.getText().substring(2));
        double playValue = Double.parseDouble(context.getText().substring(0, context.getText().indexOf(" ")));
        context.setText(context.getText().substring(context.getText().indexOf(" ") + 1));
        excute(playKey, playValue);
    }

    protected abstract void excute(String playKey, double playValue);
}
