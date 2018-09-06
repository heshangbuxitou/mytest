package com.zy.designs.prototype;

public class Main {
    /**
     * 原型模式在于使用一个原型创建出多个实例
     * 在于使用Clone方法,下面采用简历的例子来演示
     * 注意深复制与浅复制的关系
     */
    public static void main(String[] args) {
        Resume resume = new Resume("小红");
        resume.setPersonalInfo("男", "29");
        resume.setPersonalInfo("1998-2000", "XX公司");

        resume.show();

        Resume resume1 = (Resume) resume.clone();
        resume1.show();
    }
}
