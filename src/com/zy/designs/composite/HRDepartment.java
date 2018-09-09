package com.zy.designs.composite;

public class HRDepartment extends Company{
    public HRDepartment(String name) {
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
        System.out.println(name + " 公司员工招聘培训管理。");
    }
}
