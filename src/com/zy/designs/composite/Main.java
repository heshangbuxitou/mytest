package com.zy.designs.composite;

public class Main {
    public static void main(String[] args) {
        /**
         * 组合模式主要用与部分和整体表现一致的时候，它的基本对象可以被组合成
         * 更复杂的组合对象，整个结构和树的结构较类似。这个模式可以让客户可以
         * 一致的使用则和结构和单个对象。下面用公司的结构来演示组合模式。
         */
        Company root = new ConcreteCompany("北京总公司");
        root.add(new HRDepartment("总公司人力资源部"));
        root.add(new FinanceDepartment("总公司财务部"));

        Company comp = new ConcreteCompany("上海华东分公司");
        comp.add(new HRDepartment("华东分公司人力资源部"));        root.add(new FinanceDepartment("总公司财务部"));
        comp.add(new FinanceDepartment("华东分公司财务部"));
        root.add(comp);

        Company comp1 = new ConcreteCompany("南京办事处");
        comp1.add(new HRDepartment("南京办事处人力资源部"));        root.add(new FinanceDepartment("总公司财务部"));
        comp1.add(new FinanceDepartment("南京办事处公司财务部"));
        comp.add(comp1);

        Company comp2 = new ConcreteCompany("杭州办事处");
        comp2.add(new HRDepartment("杭州办事处人力资源部"));        root.add(new FinanceDepartment("总公司财务部"));
        comp2.add(new FinanceDepartment("杭州办事处公司财务部"));
        comp.add(comp2);

        System.out.println("结构图");
        root.display(2);

        System.out.println("职责");
        root.lineOfDuty();
    }
}
