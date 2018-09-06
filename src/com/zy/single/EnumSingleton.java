package com.zy.single;

public enum EnumSingleton {
    INSTACE;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
