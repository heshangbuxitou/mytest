package com.zy.test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main implements Runnable {
    private StringBuilder sb = new StringBuilder();
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    @Override
    public void run() {
    }

    public static void main(String[] args) {
        long time = Timestamp.valueOf(LocalDate.now().atStartOfDay()).getTime();
        System.out.println("time:" + time);

        HashMap<String, Integer> map = new HashMap<>(3);
        map.put("语文", 1);
        map.put("数学", 2);
        map.put("英语", 3);
        map.put("历史", 4);
        map.put("政治", 5);
        map.put("地理", 6);
        map.put("生物", 7);
        map.put("化学", 8);
        System.out.println("化学".hashCode());
        System.out.println("化学".hashCode() ^ ("化学".hashCode() >>>16));
    }
}