package com.zy.designs.observer;

public class Main {
    public static void main(String[] args) {
        /**
         * 观察者模式定义了一对多的依赖关系，它让观察者不依赖与通知者，让通知者状态改变是
         * 能及时通知到自己，优点是观察者与通知者的解偶，缺点是观察者需要实现观察者接口，这个可以
         * 用委托对象来解决。下面是Boss和雇员的例子。
         */
        BossSubject bossSubject = new BossSubject();
        NBAObserver nbaObserver = new NBAObserver(bossSubject, "小明");
        StockObserver stockObserver = new StockObserver(bossSubject, "小红");
        bossSubject.attach(nbaObserver);
        bossSubject.attach(stockObserver);
        bossSubject.setSubjectState("我王老五回来了！！");
        bossSubject.notifyObserver();
    }
}
