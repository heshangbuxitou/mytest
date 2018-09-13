package com.zy.designs.command;

public class Main {
    public static void main(String[] args) {
        /**
         * 命令模式将请求封装为一个对象，支持请求的排队和请求记录日志，它还
         * 能够很方便的支持撤销操作。命令模式将请求操作的对象和知道
         * 怎么执行操作的对象相分离（*），在需要添加新的请求时，只需要添加对应的
         *  请求对象即可完成。下面用烧烤店消费的例子来说明
         */
        Barbecuer barbecuer = new Barbecuer();
        Command bawc = new BakeChickenWingCommand(barbecuer);
        Command bawc2 = new BakeChickenWingCommand(barbecuer);
        Command bmcd = new BakeMuttonCommand(barbecuer);

        Waiter waiter = new Waiter();
        waiter.setOrder(bawc);
        waiter.setOrder(bawc2);
        waiter.setOrder(bmcd);
        waiter.notifyOrders();

        waiter.cancelOrder(bawc2);
        waiter.notifyOrders();
    }
}
