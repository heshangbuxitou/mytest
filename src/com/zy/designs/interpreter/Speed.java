package com.zy.designs.interpreter;

public class Speed extends Expression {
    @Override
    protected void excute(String playKey, double playValue) {
        String speed = "";
        if (playValue < 500) {
            speed = "快速";
        } else if (playValue >= 1000) {
            speed = "慢速";
        } else {
            speed = "中速";
        }
        System.out.print(speed + " ");
    }
}
