package com.zy.designs.observer;

import java.util.ArrayList;
import java.util.List;

public class BossSubject implements Subject {
    String action;
    List<Observer> list;
    public BossSubject(){
        list = new ArrayList<Observer>();
    }
    @Override
    public void attach(Observer observer) {
        list.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void setSubjectState(String subjectState) {
        action = subjectState;
    }

    @Override
    public String getSubjectState() {
        return action;
    }

    @Override
    public void notifyObserver() {
        for (Observer observer: list){
            observer.update();
        }
    }
}
