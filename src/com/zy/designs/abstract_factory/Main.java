package com.zy.designs.abstract_factory;

public class Main {
    /**
     * 抽象工厂模式是对工厂方法模式的扩展，它在原有工厂方法模式的基础上通过一个工厂
     * 建立多个产品，这样子产品和工厂虽然比较界限分明，但是加入要增加一个新的产品，
     * 改动会非常大，所以最好采用IOC工厂进行依赖注入的方法来生产产品，下面展示一个
     * 数据库访问的例子。
     */
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        DepartmentDao departmentDao = DataAccess.createDepartmentDao();
        UserDao userDao = DataAccess.createUserDao();

        departmentDao.getDepartmentById(123);
        departmentDao.insertDepartment(new Department());

        userDao.getUserById(123);
        userDao.insertUser(new User());
    }
}
