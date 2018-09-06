package com.zy.single;

public class Singleton {
    private Singleton() {
    }

    private static volatile Singleton instance = null;

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        EnumSingleton.INSTACE.setName("hello");
        System.out.println(EnumSingleton.INSTACE.getName());
    }
}
