package com.zy.designs.factory;

public class VolunteerFactory implements LFactory {
    @Override
    public LeiFeng createLeiFeng() {
        return new LeiFengVolunteer();
    }
}
