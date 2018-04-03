package com.fuguo.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-30 16:12
 * @since V1.0.0
 */
public class MyReentrantLock {

    public static void main(String[] args) throws InterruptedException {

        XLock xLock = new XLock();
        xLock.addValue();
        new Thread(() -> {
            xLock.doubleValue();
        }).start();

    }
}

class XLock {

    final ReentrantLock lock = new ReentrantLock();
    final Condition condition1 = lock.newCondition();
    final Condition condition2 = lock.newCondition();
    private int a = 1;

    public void addValue() {
        try {
            lock.lock();
            a++;
            condition1.await();
            condition2.signal();
            Thread.sleep(5000);
            System.out.println("addValue ==> " + a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void doubleValue() {
        try {
            lock.lock();
            a = a << 1;
            System.out.println("doubleValue ==> " + a);
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }

}
