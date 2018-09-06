package com.zy.search;

import java.util.Comparator;

public class MyUtil {

    public static <T extends Comparable<T>> int binarySearch(T[] list, T key) {
        return binarySearch(list, 0, list.length, key);
    }

    public static <T extends Comparable<T>> int binarySearch(T[] list, int low, int high, T key) {
        if (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = list[mid].compareTo(key);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                return binarySearch(list, mid + 1, high, key);
            } else {
                return binarySearch(list, low, mid - 1, key);
            }
        }
        return -1;
    }

    public static <T> int binarySearch(T[] list, Comparator<T> comp, T key) {
        int low = 0;
        int high = list.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = comp.compare(list[mid], key);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        test[] tt = new test[]{new test("1"), new test("2"), new test("3")};
        System.out.println(binarySearch(tt, new test("3")));

        String[] strings = new String[]{"1", "2", "3"};
        System.out.println(binarySearch(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }, "2"));
    }

    static class test implements Comparable<test> {
        public String ss;

        public test(String ss) {
            this.ss = ss;
        }

        @Override
        public int compareTo(test o) {
            return ss.compareTo(o.ss);
        }
    }
}
