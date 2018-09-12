package com.zy.designs.command;

public class BakeMuttonCommand extends Command{
    public BakeMuttonCommand(Barbecuer revicer) {
        super(revicer);
    }

    @Override
    public void ExcuteCommand() {
        reveicer.bakeMutton();
    }
}
