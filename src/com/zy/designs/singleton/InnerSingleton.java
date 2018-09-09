package com.zy.designs.singleton;

public class InnerSingleton {

    private static class Holder {
        private static InnerSingleton singleton = new InnerSingleton();
    }

    public static InnerSingleton getSingleton() {
        return Holder.singleton;
    }
}
