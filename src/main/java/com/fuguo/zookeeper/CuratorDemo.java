package com.fuguo.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-15 10:33
 * @since V1.0.0
 */
public class CuratorDemo {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            //启动10个线程模拟多个客户端
            Jvmlock jl = new Jvmlock(i);
            new Thread(jl).start();
            //这里加上300毫秒是为了让线程按顺序启动，不然有可能4号线程比3号线程先启动了，这样测试就不准了。
            Thread.sleep(300);
        }
    }

    public static class Jvmlock implements Runnable{

        private int num;
        public Jvmlock(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
            CuratorFramework client = CuratorFrameworkFactory
                    .newClient("127.0.0.1:2181", retryPolicy);
            client.start();

            InterProcessMutex lock = new InterProcessMutex(client,
                    "/mylock");
            try {
                System.out.println("我是第" + num + "号线程，我开始获取锁");
                lock.acquire();
                System.out.println("我是第" + num + "号线程，我已经获取锁");
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    lock.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            client.close();
        }
    }
}
