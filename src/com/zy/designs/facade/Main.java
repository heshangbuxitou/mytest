package com.zy.designs.facade;

public class Main {
    public static void main(String[] args) {
        /**
         * 外观模式 是将子类系统的模块随着不断的重构演化变得
         * 越来越复杂，会有很多小的类，如果此时直接去调用的话比较
         * 复杂，而且与子系统比较的耦合，比较好的做法建立一个外观类来
         * 执行子类操作，这样子非常符合类设计原则中的迪米特法则。
         * 下面使用几个类演示外观模式。
         */
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }
}
