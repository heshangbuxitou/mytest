package com.zy.designs.adapter;

public class Translator extends Player {

    public ForeignCenter foreignCenter;
    public Translator(String name) {
        super(name);
        foreignCenter = new ForeignCenter(name);
    }

    @Override
    public void Attack() {
        foreignCenter.进攻();
    }

    @Override
    public void Defense() {
        foreignCenter.防守();
    }
}
