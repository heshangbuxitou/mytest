package com.zy.designs.factory;

public class Main {
    /**
     *     工厂方法与简单抽象工厂的比较分析
     *     1.都是对隐藏客户端具体对象
     *     2.工厂方法把判断逻辑放到了客户端
     *     3.工厂方法中生产一个类只要创建一个工厂，由对应工厂创建，如果
     *     想换生产的产品对象，只需要修改一处。
     *     此处使用雷锋和对应雷锋生产对象来演示。
      */
    public static void main(String[] args) {

        //加入要换创建的雷锋对象，只需要换对应的工厂，如果是简单工厂模式
        //则需要换得地方比较多
        LFactory factory =  new StudentFactory();
        LeiFeng leiFeng = factory.createLeiFeng();
        LeiFeng leiFeng2 = factory.createLeiFeng();
        LeiFeng leiFeng3 = factory.createLeiFeng();

        leiFeng.BuyRice();
        leiFeng2.Sweep();
        leiFeng3.Wash();
    }
}
