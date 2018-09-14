package com.zy.designs.mediator;

public class USA extends Country{
    public USA(UnitedNations mediator) {
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
