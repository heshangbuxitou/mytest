package com.zy.designs.command;

public class BakeChickenWingCommand extends Command{
    public BakeChickenWingCommand(Barbecuer revicer) {
        super(revicer);
    }

    @Override
    public void ExcuteCommand() {
        reveicer.bakeChickenWing();
    }
}
