package com.zy.myhashmap;

public class Main {
    public static void main(String[] args) {
        MyMap<String, String> map = new MyHashMap<>();
        for (int i = 0; i < 500; i++) {
            map.put("key:" + i, "value:" + i);
        }
        for (int i = 0; i < 500; i++) {
            System.out.println("key:[" + i + "],value[" + map.get("key:" + i) + "]");
        }
    }
}
