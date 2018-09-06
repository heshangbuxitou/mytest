package com.zy.designs.abstract_factory;

public interface DepartmentDao {
    Department getDepartmentById(int id);
    void insertDepartment(Department department);
}
