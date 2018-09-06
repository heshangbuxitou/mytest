package com.zy.designs.strategy;

public class CashRebate implements CashSuper {
    private double moneyRebate = 1;
    public CashRebate(String moneyRebate){
        this.moneyRebate = Double.parseDouble(moneyRebate);
    }

    @Override
    public double accept(double money) {
        return money * moneyRebate;
    }
}
