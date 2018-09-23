package com.zy.designs.visitor;

public class Success implements Action{
    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(Man.class.getSimpleName() + " " + this.getClass().getSimpleName() + "时，背后多半有一个伟大的女人。");
    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(Woman.class.getSimpleName() + " " + this.getClass().getSimpleName() + "时，背后多半有一个不成功的男人。");
    }
}
