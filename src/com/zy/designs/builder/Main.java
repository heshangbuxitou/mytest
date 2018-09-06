package com.zy.designs.builder;

public class Main {
    public static void main(String[] args) {
        /**
         * 建造者模式是在当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配
         * 方式时适用的模式。它的好处在于将建造代码与表示代码分离，下面展示一个产品的创建
         * 过程，假设有个类有五个属性，初始化类的时候不知道需要初始化哪些属性，这时应该写五个
         * 构造方法吗？其实不用，写一个就够了，让构造者创建这个类的实现。下面这个例子是简化版的
         * 建造者实现。
         */
        Product product = new Builder().setA("部件 a").setD("部件 d").setE("部件 e").getResult();
        product.show();
    }
}
