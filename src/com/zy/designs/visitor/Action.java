package com.zy.designs.visitor;

public interface Action {
    public void getManConclusion(Man concreteElementA);
    public void getWomanConclusion(Woman concreteElementB);
}
