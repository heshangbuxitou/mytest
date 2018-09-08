package com.zy.designs.state;

public class EveningState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.isFinish()) {
            work.setState(new RestState());
            work.writeProgram();
        } else {
            if (work.getHour() < 21) {
                System.out.println("当前时间" + work.getHour() + "点 加班中，很疲劳！！");
            } else {
                work.setState(new SleepingState());
                work.writeProgram();
            }
        }


    }
}
