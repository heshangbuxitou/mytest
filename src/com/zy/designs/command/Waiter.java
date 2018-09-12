package com.zy.designs.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Waiter {
    private List<Command> orders = new ArrayList<>();

    public void setOrder(Command command){
        orders.add(command);
        System.out.println("增加订单" + command.toString() + " :时间" + new Date().toString());
    }

    public void cancelOrder(Command command){
        orders.remove(command);
        System.out.println("取消订单" + command.toString() + " :时间" + new Date().toString());
    }

    public void notifyOrders(){
        for (Command comd: orders) {
            comd.ExcuteCommand();
        }
    }
}
