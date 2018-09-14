package com.zy.designs.mediator;

public class Main {
    public static void main(String[] args) {
        /**
         * 中介者模式是迪米特法则的运用之一，它让各个对象不直接通信，而是通过第三方来调用的
         * 方法来完成通信，对象之间的重点由对象行为转移到了对象的交互，充分的降低了对象
         * 之间的耦合性。中介者模式存在的缺点是 中介者需要知道所有的对象，这样中介者对象的行为会随着
         * 对象的增加而逐渐复杂。下面用联合国的例子来说明。
         */
        UnitedNationsImpl unsl = new UnitedNationsImpl();
        USA usa = new USA(unsl);
        Iraq iraq = new Iraq(unsl);
        unsl.setCountries(usa, iraq);

        usa.declare("不准研制核武器，否则要发动战争！！！");
        iraq.declare("我们没有研制核武器，也不怕侵略！！！");
    }
}
