package com.zy.designs.iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        /**
         * 迭代器模式主要用于对集合的遍历，它使用迭代器作为接口，定义了
         * 常用的迭代器方法，具体的迭代器需要实现这些抽象方法，这个模式在
         * 现有的高级语言中都做了封装，我们只需要熟悉一下这个模式的运用。
         * 现在用公交车查票来展示这个模式。
         */
        ConcreteAggregate ctat = new ConcreteAggregate<String>();
        ctat.add("小红");
        ctat.add("小明");
        ctat.add("小李");
        ctat.add("小包");

        MyIterator iterator = ctat.CreateIterator();
        while (iterator.hasNext()){
            System.out.println("售票员查" + iterator.next() + "的票");
        }
    }
}
