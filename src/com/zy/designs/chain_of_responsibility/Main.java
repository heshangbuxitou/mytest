package com.zy.designs.chain_of_responsibility;

public class Main {
    /**
     * 职责链模式用于多个对象处理一个请求的模式，它可以避免请求的发送者和接收者之间
     * 的耦合，把请求的传递交给接受者来处理，接收者之间存在联系，请求在接受者之间传递，
     * 直到有接受者处理为止，下面用一个请假的实例来说明职责链模式。
     */
    public static void main(String[] args) {
        CommonManager jinli = new CommonManager("经理");
        MajorManager zongjian = new MajorManager("总监");
        GeneralManager dongshizhang = new GeneralManager("董事长");
        jinli.setSuperior(zongjian);
        zongjian.setSuperior(dongshizhang);

        Request request = new Request();
        request.setRequestType("请假");
        request.setRequestContent("有事情外出");
        request.setNumber(1);
        jinli.requestApplication(request);

        Request request2 = new Request();
        request.setRequestType("请假");
        request.setRequestContent("有事情外出");
        request.setNumber(4);
        jinli.requestApplication(request);

        Request request3 = new Request();
        request.setRequestType("加薪");
        request.setRequestContent("员工想要加薪");
        request.setNumber(500);
        jinli.requestApplication(request);

        Request request4 = new Request();
        request.setRequestType("加薪");
        request.setRequestContent("员工想要加薪");
        request.setNumber(1000);
        jinli.requestApplication(request);
    }
}
