package com.zy.designs.observer;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void setSubjectState(String subjectState);
    String getSubjectState();
    void notifyObserver();
}
