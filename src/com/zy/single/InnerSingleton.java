package com.zy.single;

public class InnerSingleton {
    private InnerSingleton() {
    }

    private static class Holder {
        private static InnerSingleton singleton = new InnerSingleton();
    }

    public InnerSingleton getSingleton() {
        return Holder.singleton;
    }
}
