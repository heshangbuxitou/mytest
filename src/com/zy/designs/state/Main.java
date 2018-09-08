package com.zy.designs.state;

public class Main {
    public static void main(String[] args) {
        /**
         * 状态模式主要用与 当一个类的行为和它的状态有关时使用的，模式将状态用
         * 类封装起来，让状态类来控制状态的变化，这样可以很容易的增加新的状态和转换。
         * 下面展示一个 工作状态的改变例子。
         */
        Work work = new Work();
        work.setHour(9);
        work.writeProgram();
        work.setHour(10);
        work.writeProgram();
        work.setHour(12);
        work.writeProgram();
        work.setHour(13);
        work.writeProgram();
        work.setHour(14);
        work.writeProgram();
        work.setHour(15);
        work.writeProgram();
        work.setHour(17);
        work.writeProgram();

        work.setFinish(true);
        work.setHour(19);
        work.writeProgram();
        work.setHour(22);
        work.writeProgram();
    }
}
