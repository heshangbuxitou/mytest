package com.zy.designs.decoration;

public class Main {

    public static void main(String[] args) {
        //装饰器模式的实现
        //通过一个人穿衣服来演示装饰器,装饰器可以动态的给要装饰的类添加功能
        //通常在加强原有类的核心职责或主要行为时使用
        Person person = new Person("张三");
        TShirt tShirt = new TShirt();
        BigTrouser bigTrouser = new BigTrouser();
        TSuit tSuit = new TSuit();

        tShirt.setPerson(person);
        bigTrouser.setPerson(tShirt);
        tSuit.setPerson(bigTrouser);
        tShirt.show();

    }
}
