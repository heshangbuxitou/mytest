package com.zy.designs.adapter;

public class Main {
    public static void main(String[] args) {
        /**
         * 适配器模式指的是将原有类的接口适配成为客户需要的接口，通常用于原本接口
         * 不兼容而不能一起工作的问题，下面使用打篮球的例子来说明。
         */
        Player b = new ForWards("巴底而");
        b.Attack();

        Player mk =  new Guards("麦克格雷迪");
        mk.Attack();

        Player ym = new Translator("姚明");
        ym.Attack();
        ym.Defense();
    }
}
