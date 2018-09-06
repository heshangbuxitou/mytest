package com.zy.sort;

import java.util.Comparator;

public interface Sorter {
    /**
     * 排序
     * @param list 需要排序的数组
     * @param <T>
     */
    public <T extends Comparable<T>> void sort(T[] list);

    /**
     * 排序
     * @param list 需要排序的数组
     * @param comp 比较器
     * @param <T>
     */
    public <T> void sort(T[] list, Comparator<T> comp);
}
