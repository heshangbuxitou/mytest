package com.zy.designs;


public class Factory {
    private Factory(){}

    public static Operator createOperation(String operate){
        Operator operator;
        switch (operate){
            case "+":
                operator = new OperatorAdd();
                break;
            case "-":
                operator = new OperatorSub();
                break;
            case "*":
                operator = new OperatorMul();
                break;
            case "/":
                operator = new OperatorDiv();
                break;
            default:
                throw new RuntimeException("请输入正确的操作符号..");
        }
        return operator;
    }
}
