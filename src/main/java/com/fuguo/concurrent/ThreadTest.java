package com.fuguo.concurrent;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-16 13:24
 * @since V1.0.0
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            System.out.println("qqqqqqqqqq");
        });
        Thread thread = new Thread(() -> {
            try {
                //Thread.sleep(1000);
                thread1.join();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("tttttttttt");
        });
        thread.start();
        thread1.start();


    }
}
