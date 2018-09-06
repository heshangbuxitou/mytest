package com.zy.designs.proxy;

public class Main {
    public static void main(String[] args) {
        //代理模式主要是通过代理类代替原有类进行交互
        //此处使用帮人传纸条来模拟这个过程
        //代理模式主要运用于隐藏原有类一些细节，比如虚拟代理，需要创建开销
        //很大的对象，通过它来存放实例化需要很长时间的真实对象。比如浏览器加载图片
        SchoolGirl girl = new SchoolGirl("李交交");
        Proxy proxy = new Proxy(girl);

        proxy.GiveChocolate();
        proxy.GiveDolls();
        proxy.GiveFlower();
    }
}
