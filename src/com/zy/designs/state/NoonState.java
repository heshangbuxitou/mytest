package com.zy.designs.state;

public class NoonState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 13) {
            System.out.println("当前时间" + work.getHour() + "点 饿了，午饭，犯困");
        } else {
            work.setState(new AfterNoonState());
            work.writeProgram();
        }
    }
}
