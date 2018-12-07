package com.zy.myhashmap;

import com.zy.myhashmap.Entry;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int defaultInitSize;
    private float defaultLocdFactor;

    private int entryUseSize;

    private Entry<K, V>[] table = null;

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int defaultInitialCapacity, float defaultLoadFactor) {
        if (defaultInitialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity" + defaultInitialCapacity);
        }

        if (defaultLoadFactor < 0 || Float.isNaN(defaultLoadFactor)) {
            throw new IllegalArgumentException("Illegal load factor" + defaultLoadFactor);
        }
        this.defaultInitSize = defaultInitialCapacity;
        this.defaultLocdFactor = defaultLoadFactor;
        table = new Entry[this.defaultInitSize];
    }

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        // 进行扩容的检查
        if (entryUseSize >= defaultInitSize * defaultLocdFactor) {
            resize(2 * defaultInitSize);
        }

        int index = hash(key) & (defaultInitSize - 1);
        if (table[index] == null) {
            table[index] = new Entry<K, V>(key, value, null);
            ++entryUseSize;
        } else {
            Entry<K, V> entry = table[index];
            Entry<K, V> e = entry;
            while (e != null) {
                if (key == e.getKey() || key.equals(e.getKey())) {
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
                e = e.next;
            }
            table[index] = new Entry<K, V>(key, value, entry);
            ++entryUseSize;
        }
        return oldValue;
    }

    public int hash(K k) {
        int hashCode = k.hashCode();
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
    }

    public void resize(int newLen) {
        // 没有对长度进行检测，有可能长度会大于最大Int。
        Entry<K, V>[] newTable = new Entry[newLen];
        entryUseSize = 0;
        defaultInitSize = newLen;
        rehash(newTable);
    }

    public void rehash(Entry<K, V>[] entryNewTable) {
        // 获取所有的Entry
        List<Entry<K, V>> entrieList = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                entrieList.add(entry);
                entry = entry.next;
            }
        }
        if (entryNewTable.length > 0)
            table = entryNewTable;
        for (Entry<K, V> entry : entrieList) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public V get(K key) {
        int index = hash(key) & (defaultInitSize - 1);
        if (key == null) {
            Entry<K, V> entry = table[index];
            while (entry != null) {
                if (entry.getKey() == null) {
                    return entry.getValue();
                }
                entry = entry.next;
            }
        } else {
            Entry<K, V> entry = table[index];
            while (entry != null) {
                if (entry == key || key.equals(entry.getKey())) {
                    return entry.getValue();
                }
                entry = entry.next;
            }
        }
        return null;
    }
}

class Entry<K, V> implements MyMap.MyEntry<K, V> {
    public K key;
    public V value;
    public Entry<K, V> next;

    public Entry() {
    }

    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}


