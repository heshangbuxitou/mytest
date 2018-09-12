package com.zy.designs.bridge;

public class Main {
    public static void main(String[] args) {
        /**
         * 桥接模式注重抽象与实现的分离，它继承的事优先使用组合而不是继承的软件的思想，
         * 如果多次使用继承的话，会使软件成为庞然大物，这样非常不利于维护，使用桥接模式
         * 分离软件的实现，对他们进行解耦才是正确的选择，下面使用手机软件和手机品牌的例子
         * 演示。
         */
        HandSetBrand asb = new HandSetBrandA(new HandSetGame());
        asb.Run();

        asb.setSoft(new HandSetAddressList());
        asb.Run();

        HandSetBrand asb2 = new HandSetBrandB(new HandSetGame());
        asb2.Run();

        asb2.setSoft(new HandSetAddressList());
        asb2.Run();

    }
}
