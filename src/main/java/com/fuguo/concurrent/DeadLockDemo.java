package com.fuguo.concurrent;

/**
 * Created by MBENBEN on 2018/4/8.
 */
public class DeadLockDemo {
    static Book book1 = new Book();
    static Book book2 = new Book();
    public static void main(String[] args) {

        new Thread(() -> {
            try {
                synchronized (book1) {
                    Thread.sleep(1000);
                    book2.getBook();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                synchronized (book2) {
                    Thread.sleep(1000);
                    book1.getBook();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class Book {

    public synchronized Book getBook() {
        return new Book();
    }
}
