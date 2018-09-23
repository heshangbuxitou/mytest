package com.zy.designs.visitor;

public class Man implements Person{
    @Override
    public void accept(Action visitor) {
        visitor.getManConclusion(this);
    }
}
