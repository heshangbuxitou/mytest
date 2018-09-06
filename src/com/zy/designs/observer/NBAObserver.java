package com.zy.designs.observer;

public class NBAObserver extends Observer {
    public NBAObserver(Subject subject, String name) {
        super(subject, name);
    }

    @Override
    public void update() {
        System.out.println(subject.getSubjectState() + ','+ name + "关闭NBA，继续工作");
    }
}
