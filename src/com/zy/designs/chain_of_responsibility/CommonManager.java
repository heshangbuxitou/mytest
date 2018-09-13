package com.zy.designs.chain_of_responsibility;

public class CommonManager extends Manager{
    public CommonManager(String name) {
        super(name);
    }

    @Override
    public void requestApplication(Request request) {
        if (request.requestType.equals("请假") && request.number<2){
            System.out.println(name + ":" + request.requestContent + " 数量 " + request.number + "被批准！！");
        }else {
            superior.requestApplication(request);
        }
    }
}
