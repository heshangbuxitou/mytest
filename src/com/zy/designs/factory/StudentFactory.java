package com.zy.designs.factory;

public class StudentFactory implements LFactory{
    @Override
    public LeiFeng createLeiFeng() {
        return new LeiFengStudent();
    }
}
