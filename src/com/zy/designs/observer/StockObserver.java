package com.zy.designs.observer;

public class StockObserver extends Observer {
    public StockObserver(Subject subject, String name) {
        super(subject, name);
    }

    @Override
    public void update() {
        System.out.println(subject.getSubjectState() + ','+ name + "关闭股票，继续工作");
    }
}
