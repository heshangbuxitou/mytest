package com.zy.designs.state;

public class Work {


    public State current;
    private double hour;
    private boolean finish;

    public Work() {
        current = new ForenoonState();
        finish = false;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public void writeProgram() {
        current.writeProgram(this);
    }

    public State getState() {
        return current;
    }

    public void setState(State current) {
        this.current = current;
    }
}
