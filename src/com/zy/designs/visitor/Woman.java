package com.zy.designs.visitor;

public class Woman implements Person{
    @Override
    public void accept(Action visitor) {
        visitor.getWomanConclusion(this);
    }
}
