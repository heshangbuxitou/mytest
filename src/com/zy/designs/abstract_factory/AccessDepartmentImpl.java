package com.zy.designs.abstract_factory;

public class AccessDepartmentImpl implements DepartmentDao {
    @Override
    public Department getDepartmentById(int id) {
        System.out.println("AccessDepartmentImpl 的 getDepartmentById 方法");
        return null;
    }

    @Override
    public void insertDepartment(Department user) {
        System.out.println("AccessDepartmentImpl 的 insertDepartment 方法");
    }

}
