package test.com.zy.test;

import java.util.concurrent.Semaphore;

public class ManyThreadPrint {
    public static int result = 0;

    public static void main(String[] args) throws InterruptedException {
        int N = 3;
        final Semaphore[] syncObjects = new Semaphore[N];
        for (int i = 0; i < N; i++) {
            syncObjects[i] = new Semaphore(1);
            if (i != N - 1) {
                syncObjects[i].acquire();
            }
        }
        for (int i = 0; i < N; i++) {
            final Semaphore lastSemaphore = i == 0 ? syncObjects[N - 1] : syncObjects[i - 1];
            final Semaphore curSemaphore = syncObjects[i];
            final int index = i;
            Thread thread = new Thread(() -> {
                while (result <= 100) {
                    try {
                        lastSemaphore.acquire();
                        System.out.println("Thread " + index + ":" + result++);
                        if(result > 100){
                            System.exit(0);
                        }
                        curSemaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}
