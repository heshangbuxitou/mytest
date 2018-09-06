package com.zy.designs.decoration;

public class Person {
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.print("我的名字是" + name + ",开始穿 ");
    }
}
