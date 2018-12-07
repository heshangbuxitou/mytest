package com.zy.myhashmap;

public interface MyMap<K, V> {

    public V put(K key, V value);

    public V get(K key);

    interface MyEntry<K, V> {
        public K getKey();

        public V getValue();
    }
}
