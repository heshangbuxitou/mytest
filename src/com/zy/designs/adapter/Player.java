package com.zy.designs.adapter;

public abstract class Player {
    public String name;
    public Player(String name){
        this.name = name;
    }
    public abstract void Attack();
    public abstract void Defense();
}
