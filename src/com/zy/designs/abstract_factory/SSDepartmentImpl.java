package com.zy.designs.abstract_factory;

public class SSDepartmentImpl implements DepartmentDao{
    @Override
    public Department getDepartmentById(int id) {
        System.out.println("SSDepartmentImpl 的 getDepartmentById 方法");

        return null;
    }

    @Override
    public void insertDepartment(Department department) {
        System.out.println("SSDepartmentImpl 的 insertDepartment 方法");
    }
}
