package com.zy.designs.command;

public abstract class Command {
    Barbecuer reveicer;
    public Command(Barbecuer revicer){
        this.reveicer = revicer;
    }

    abstract void ExcuteCommand();
}
