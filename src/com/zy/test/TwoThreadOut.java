package com.zy.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreadOut {
    /**
     * 双线程交替打印奇偶数
     */
    private int start = 1;
    private Lock lock = new ReentrantLock();
    private boolean flag = false;

    public static class OuThread implements Runnable{
        public TwoThreadOut number;
        public OuThread(TwoThreadOut number){
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= 100){
                if(number.flag){
                    try{
                        number.lock.lock();
                        System.out.println(Thread.currentThread().getName() + "+-+"+ number.start);
                        number.start++;
                        number.flag = !number.flag;
                    } finally {
                        number.lock.unlock();
                    }
                }else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class JiThread implements Runnable{
        public TwoThreadOut number;
        public JiThread(TwoThreadOut number){
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= 100){
                if(!number.flag){
                    try{
                        number.lock.lock();
                        System.out.println(Thread.currentThread().getName() + "+-+"+ number.start);
                        number.start++;
                        number.flag = !number.flag;
                    } finally {
                        number.lock.unlock();
                    }
                }else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TwoThreadOut threadOut = new TwoThreadOut();
        Thread thread = new Thread(new OuThread(threadOut));
        thread.setName("偶数线程");
        Thread thread2 = new Thread(new JiThread(threadOut));
        thread2.setName("奇数线程");
        thread.start();
        thread2.start();
//        thread.join();
//        thread2.join();
    }
}
