package com.zy.designs.memento;

public class Main {
    public static void main(String[] args) {
        /**
         * 备忘录模式用于保存需要记录历史信息的类，将信息保存到备忘录类中，
         * 然后在某个时间点可以从备忘录恢复这些数据，下面用游戏中保存
         * 人物状态的例子来展示。
         */
        GamePerson person = new GamePerson();
        person.initState();
        person.show();

        RoleStateManager manager = new RoleStateManager();
        manager.setMemento(person.saveState());

        person.fight();
        person.show();

        person.rocoveryState(manager.getMemento());
        person.show();

    }
}
