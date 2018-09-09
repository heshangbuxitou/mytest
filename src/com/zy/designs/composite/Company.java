package com.zy.designs.composite;

public abstract class Company {
    public String name;
    public Company(String name){
        this.name = name;
    }

    public abstract void add(Company comp);
    public abstract void remove(Company comp);
    public abstract void display(int depth);
    public abstract void lineOfDuty();
}
