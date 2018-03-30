package com.fuguo.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-21 17:26
 * @since V1.0.0
 */
public class TestSemaphore {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(2, true);

        new Thread(() -> {
            try {
                semaphore.acquire(1);
                System.out.println("Thread1 get semaphore");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Thread1 release semaphore");
                semaphore.release(1);
            }
        }).start();

        new Thread(() -> {
            try {
                semaphore.acquire(1);
                System.out.println("Thread2 get semaphore");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Thread2 release semaphore");
                semaphore.release(1);
            }
        }).start();
        semaphore.acquire(1);
        System.out.println("main get semaphore");
        Thread.sleep(200);
        System.out.println("main release semaphore");
        semaphore.release(1);
        System.out.println();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {

    }
}
