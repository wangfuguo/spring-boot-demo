package com.fuguo.concurrent;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-19 15:15
 * @since V1.0.0
 */
public class WaitMethodTest {


    public static void main(String[] args){
        Object object = new Object();
        new Thread(new MyThread(object)).start();

        System.out.println("main is over.");

    }
}

class MyThread implements Runnable {

    private Object object = null;

    public MyThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        try {
            synchronized (object) {
                object.wait(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wait end...");
    }
}