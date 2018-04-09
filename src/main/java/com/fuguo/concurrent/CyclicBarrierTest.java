package com.fuguo.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by MBENBEN on 2018/4/8.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, ()->{
            System.out.println("the barrier is tripped.");
        });

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " wait.");
                cyclicBarrier.await();
                cyclicBarrier.reset();
                System.out.println(Thread.currentThread().getName() + " has finished.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println(Thread.currentThread().getName() + " wait.");
        cyclicBarrier.await();
        System.out.println(Thread.currentThread().getName() + " has finished.");
    }
}
