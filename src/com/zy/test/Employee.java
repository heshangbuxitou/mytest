package com.zy.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.logging.Logger;

public class Employee extends Person{

    public Employee(String firstName, String lastName, int age, int height, int weight, String eyeColor, String gender) {
        super(firstName, lastName, age, height, weight, eyeColor, gender);
    }
    public Employee(){
        super();
    }

    private String taxpayerIdentificationNumber;
    private String employeeNumber;
    private BigDecimal salary;
    public String getTaxpayerIdentificationNumber() {
        return taxpayerIdentificationNumber;
    }

    public void setTaxpayerIdentificationNumber(String taxpayerIdentificationNumber) {
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Employee equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        if (taxpayerIdentificationNumber != null ? !taxpayerIdentificationNumber.equals(employee.taxpayerIdentificationNumber) : employee.taxpayerIdentificationNumber != null)
            return false;
        if (employeeNumber != null ? !employeeNumber.equals(employee.employeeNumber) : employee.employeeNumber != null)
            return false;
        return salary != null ? salary.equals(employee.salary) : employee.salary == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (taxpayerIdentificationNumber != null ? taxpayerIdentificationNumber.hashCode() : 0);
        result = 31 * result + (employeeNumber != null ? employeeNumber.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "Employee [taxpayerIdentificationNumber=" + taxpayerIdentificationNumber +
                ", employeeNumber=" + employeeNumber + ", salary=" + salary + "]";
    }

    @Override
    public void printAudit(StringBuilder buffer) {
        buffer.append(toString());
    }

    public static void main(String[] args) {
//        Employee employee = new Employee("Joe", "Q Author", 42, 173, 82, "Brown", "MALE");
//        Logger l = Logger.getLogger(Employee.class.getName());
//        employee.printAudit(l);

        Logger l = Logger.getLogger(Employee.class.getName());
        Employee employee1 = new Employee();
        employee1.setFirstName("J Smith");
        Employee employee2 = new Employee();
        employee2.setFirstName("J Smith");
        l.info("Q: employee1 == employee2?      A:" + (employee1 == employee2));
        l.info("Q: employee1.equals(employee2)?A:" + employee1.equals(employee2));
        l.severe("Q: employee1.equals(employee2)?A:" + employee1.equals(employee2));
    }
}
