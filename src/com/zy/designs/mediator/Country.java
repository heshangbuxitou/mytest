package com.zy.designs.mediator;

public abstract class Country {
    public UnitedNations mediator;

    public Country(UnitedNations mediator){
        this.mediator = mediator;
    }

    public abstract void declare(String message);
    public abstract void getMessage(String message);
}
