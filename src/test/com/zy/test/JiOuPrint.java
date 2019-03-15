package test.com.zy.test;

import java.util.concurrent.Semaphore;

public class JiOuPrint implements Runnable{
    public static int value = 0;
    @Override
    public void run() {
        while (value <= 100){
            synchronized (JiOuPrint.class){
                System.out.println(Thread.currentThread().getName() + ":++++++++" + value++);
                JiOuPrint.class.notify();
                try {
                    if(value > 100){
                        break;
                    }
                    JiOuPrint.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
//        new Thread(new JiOuPrint(), "偶数").start();
//        new Thread(new JiOuPrint(), "奇数").start();
        Semaphore syncObjects = new Semaphore(1);


    }
}
