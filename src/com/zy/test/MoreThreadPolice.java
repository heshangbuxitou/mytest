package com.zy.test;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MoreThreadPolice {
    public final static BlockingQueue<String> queue = new LinkedBlockingDeque<>();
    public final static Map<String, Integer> map = new ConcurrentHashMap<>();

    public MoreThreadPolice() {
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 20000; i++) {
            String value = String.valueOf(random.nextInt(2));
            queue.add(value);
        }
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(new DealThread());
            list.add(t);
            t.start();
        }
        for (Thread t : list) {
            t.join();
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        System.out.println("count=" + count);
    }

    public static class DealThread implements Runnable {

        @Override
        public void run() {
            while (queue.size() > 0) {
                String key = null;
                try {
                    key = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 获取到唯一的Key的锁
                String realKey = key.intern();
                System.out.println("key cache address: " + System.identityHashCode(realKey));
                synchronized (realKey) {
                    if (map.containsKey(realKey)) {
                        Integer i = map.get(realKey);
                        map.put(realKey, i + 1);
                    } else {
                        map.put(realKey, 1);
                    }
                }
            }
        }
    }
}
