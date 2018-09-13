package com.zy.designs.chain_of_responsibility;

public class GeneralManager extends Manager {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void requestApplication(Request request) {
        if (request.requestType.equals("请假")) {
            System.out.println(name + ":" + request.requestContent + " 数量 " + request.number + "被批准！！");
        } else if (request.requestType.equals("加薪") && request.number <= 500) {
            System.out.println(name + ":" + request.requestContent + " 数量 " + request.number + "被批准！！");
        } else if (request.requestType.equals("加薪") && request.number > 500) {
            System.out.println(name + ":" + request.requestContent + " 数量 " + request.number + "在说吧！！");
        }
    }
}
