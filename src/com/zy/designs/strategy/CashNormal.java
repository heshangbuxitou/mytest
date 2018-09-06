package com.zy.designs.strategy;

public class CashNormal implements CashSuper {
    @Override
    public double accept(double money) {
        return money;
    }
}
