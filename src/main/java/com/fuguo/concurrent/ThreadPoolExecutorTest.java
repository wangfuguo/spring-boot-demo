package com.fuguo.concurrent;

import java.util.concurrent.*;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-15 14:35
 * @since V1.0.0
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args){

        ExecutorService executorService = new ThreadPoolExecutor(5, 8, 20, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(6, true), (r, executor) -> {
            throw new RuntimeException("任务执行失败！" + Thread.currentThread().getName());
        });
        //executorService.allowCoreThreadTimeOut(true);
//        ThreadFactory build = new ThreadFactoryBuilder().build();
        for (int i = 0; i < 200; i++) {
//            Thread thread = build.newThread(() -> {
//                System.out.println(Thread.currentThread().getName());
//            });
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
        ExecutorService service = Executors.newSingleThreadExecutor();
        System.out.println();

        Thread thread = new Thread(() -> {

        });

    }
}