package com.zy.designs.facade;

public class Facade {
    SystemOne one;
    SystemTwo two;
    SystemThree three;

    public Facade() {
        one = new SystemOne();
        two = new SystemTwo();
        three = new SystemThree();
    }

    public void methodA() {
        one.methodOne();
        three.methodThree();
    }

    public void methodB() {
        two.methodTwo();
    }
}
