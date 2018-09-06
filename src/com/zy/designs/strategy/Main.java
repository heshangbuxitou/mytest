package com.zy.designs.strategy;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    //商场打折算法 策略模式实现
    //使用简单工厂实现打折类的创建？
    // 一是商场如果随时的想要添加不同的计算方式，比如添加积分返利，需要重新添加积分类，
    // 每次打折的力度和返利额度改变，简单工厂都需要重新修改和编译，这样不好
    //策略模式使用一个Context封装算法，使算法与业务相隔离
    //通过只传入打折的类型值，将算法类完全隐藏在业务外面
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        double money = 1000;
        String type = "满300返100";
        String type2 = "正常收费";
        String type3 = "打五折";

        CashContext context = new CashContext(type3);
        System.out.println(context.getResult(money));
    }
}
