package com.zy.designs.adapter;

public class ForWards extends Player {
    public ForWards(String name) {
        super(name);
    }

    @Override
    public void Attack() {
        System.out.println("前锋 " + name + " 进攻");
    }

    @Override
    public void Defense() {
        System.out.println("前锋 " + name + " 防守");
    }
}
