package com.zy.designs.composite;

import java.util.ArrayList;
import java.util.List;

public class ConcreteCompany extends Company{

    List<Company> childrenCompanies = new ArrayList<>();
    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    public void add(Company comp) {
        childrenCompanies.add(comp);
    }

    @Override
    public void remove(Company comp) {
        childrenCompanies.remove(comp);
    }

    @Override
    public void display(int depth) {
        System.out.println(Util.getNumString("-", depth) + name);
        for (Company company: childrenCompanies){
            company.display(depth + 2);
        }
    }

    @Override
    public void lineOfDuty() {
        for (Company company: childrenCompanies){
            company.lineOfDuty();
        }
    }
}
