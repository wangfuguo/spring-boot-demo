package com.fuguo.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-04-02 8:41
 * @since V1.0.0
 */
public class MyCondition {

    public static void main(String[] args){

        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition condition = reentrantLock.newCondition();

        new Thread(() -> {
            reentrantLock.lock();
            System.out.println("I need new single.");
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("I get a single.");
                reentrantLock.unlock();
            }
        }).start();

        new Thread(() -> {
            reentrantLock.lock();
            System.out.println("I get lock.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                condition.signalAll();
                System.out.println("I send a single.");
                reentrantLock.unlock();
            }
        }).start();

        System.out.println();

    }
}
