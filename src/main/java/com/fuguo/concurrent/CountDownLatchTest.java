package com.fuguo.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-16 13:33
 * @since V1.0.0
 */
public class CountDownLatchTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 数量 ==>" + countDownLatch.getCount());
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " process over ... ");
    }
}
