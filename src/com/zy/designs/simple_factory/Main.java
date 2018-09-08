package com.zy.designs.simple_factory;

public class Main {
    public static void main(String[] args) {
        String numberA = "5";
        String numberB = "6";
        String operator = "*";

        Operator operation = Factory.createOperation(operator);
        operation.numberA = Double.parseDouble(numberA);
        operation.numberB = Double.parseDouble(numberB);
        System.out.println(operation.getResult());
    }
}
