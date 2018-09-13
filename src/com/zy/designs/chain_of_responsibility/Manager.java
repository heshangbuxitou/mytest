package com.zy.designs.chain_of_responsibility;

public abstract class Manager {
    public String name;
    public Manager superior;

    public Manager(String name) {
        this.name = name;
    }

    public Manager getSuperior() {
        return superior;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    public abstract void requestApplication(Request request);
}


