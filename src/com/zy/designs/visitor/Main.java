package com.zy.designs.visitor;

public class Main {
    public static void main(String[] args) {
        /**
         * 访问者模式，表示对某个对象结构中各元素的操作，他可以方便的定义新操作，
         * 每个操作都封装在自己的Visitor中，它主要用于对象结构比较稳定的系统，因为访问者需要
         * 在事前知道有哪些对象结构，这样才能方便增加新的访问者，借用GOF作者的话说，
         * 大多数时候不需要用访问者模式，一旦用的时候，那就是真的需要他了。下面用男人女人的状态
         * 的例子来说明。
         */
        Man man = new Man();
        Woman woman = new Woman();
        ObjectStructure stucture = new ObjectStructure();
        stucture.attach(man);
        stucture.attach(woman);

        Success success = new Success();
        stucture.display(success);

        Failing failing = new Failing();
        stucture.display(failing);

        Amativense amativense = new Amativense();
        stucture.display(amativense);

        Marriage marriage = new Marriage();
        stucture.display(marriage);
    }
}
