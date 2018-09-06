package com.zy.sort;

import java.util.Comparator;

public class BubbleSorter implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        boolean swap = true;
        for (int i = 1, len = list.length; i < len && swap; i++) {
            swap = false;
            for (int j = 0; j < len - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    swap = true;
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator<T> comp) {
        boolean swap = true;
        for (int i = 1, len = list.length; i < len && swap; i++) {
            swap = false;
            for (int j = 0; j < j - i; j++) {
                if (comp.compare(list[j], list[j + 1]) > 0) {
                    swap = true;
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

}
