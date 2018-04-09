package com.fuguo.concurrent;

/**
 * Created by MBENBEN on 2018/4/7.
 */
public class ThreadLocalTest {

    static final ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

    static {
        integerThreadLocal.set(1);
    }

    public static void main(String[] args) {
        new Thread(() -> {
            integerThreadLocal.set(2);
        }).start();
        new Thread(() -> {
            integerThreadLocal.set(20);
        }).start();
        integerThreadLocal.set(50);
        System.out.println(integerThreadLocal.get());
    }
}
