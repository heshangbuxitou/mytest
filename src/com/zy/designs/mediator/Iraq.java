package com.zy.designs.mediator;

public class Iraq extends Country{
    public Iraq(UnitedNations mediator) {
        super(mediator);
    }

    @Override
    public void declare(String message) {
        mediator.declare(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println(this.getClass().getSimpleName() + "获取消息: " + message);
    }
}
