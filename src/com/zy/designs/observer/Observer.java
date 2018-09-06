package com.zy.designs.observer;

public abstract class Observer {
    public Subject subject;
    public String name;

    public Observer(Subject subject, String name) {
        this.subject = subject;
        this.name = name;
    }

    public abstract void update();
}
