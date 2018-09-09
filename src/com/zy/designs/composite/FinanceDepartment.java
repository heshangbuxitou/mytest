package com.zy.designs.composite;

public class FinanceDepartment extends Company{
    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company comp) {
    }

    @Override
    public void remove(Company comp) {
    }

    @Override
    public void display(int depth) {
        System.out.println(Util.getNumString("-", depth) + name);
    }

    @Override
    public void lineOfDuty() {
        System.out.println(name + " 公司财务收支管理。。");
    }
}
