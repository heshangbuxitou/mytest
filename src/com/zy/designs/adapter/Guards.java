package com.zy.designs.adapter;

public class Guards extends Player {
    public Guards(String name) {
        super(name);
    }

    @Override
    public void Attack() {
        System.out.println("后卫 " + name + " 进攻");
    }

    @Override
    public void Defense() {
        System.out.println("后卫 " + name + " 防守");
    }
}
