package com.zy.designs.visitor;

public class Marriage implements Action {
    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(Man.class.getSimpleName() + " " + this.getClass().getSimpleName() +
                "时，感慨到：恋爱游戏终结时，有妻徒刑遥遥无期。。。");
    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(Woman.class.getSimpleName() + " " + this.getClass().getSimpleName() +
                "时，欣慰到：爱情长跑路漫漫，婚姻保险保护平安");
    }
}
