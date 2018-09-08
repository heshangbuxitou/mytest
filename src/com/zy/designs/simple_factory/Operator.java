package com.zy.designs.simple_factory;

public abstract class Operator {
    double numberA;

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    double numberB;


    abstract double getResult();
}
