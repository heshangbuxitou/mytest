package com.zy.designs.singleton;

public class Main {
    public static void main(String[] args) {
        /**
         * 单例模式用于只需要实例化一个类时候的情况，单例模式有许多实现的方法，
         * 列举了几个实现比较好的，兼容多线程的单例模式例子。
         */
        EnumSingleton enumSingleton = EnumSingleton.INSTACE;
        EnumSingleton enumSingleton2 = EnumSingleton.INSTACE;
        System.out.println(enumSingleton == enumSingleton2);

        InnerSingleton innerSingleton = InnerSingleton.getSingleton();
        InnerSingleton innerSingleton2 = InnerSingleton.getSingleton();
        System.out.println(innerSingleton == innerSingleton2);

        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);
    }
}
