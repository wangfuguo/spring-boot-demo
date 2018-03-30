package com.fuguo.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.queue.SimpleDistributedQueue;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-15 10:42
 * @since V1.0.0
 */
public class DistributedQueueTest {

    public static void main(String[] args){

        String path = "/myDisQueue";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
        CuratorFramework curatorFramework = CuratorFrameworkFactory
                .newClient("127.0.0.1:2181", retryPolicy);
        curatorFramework.start();
        SimpleDistributedQueue simpleDistributedQueue = new SimpleDistributedQueue(curatorFramework, path);
        try {
            simpleDistributedQueue.offer("google".getBytes());
            simpleDistributedQueue.offer("apple".getBytes());
            simpleDistributedQueue.offer("amazon".getBytes());
            simpleDistributedQueue.offer("facebook".getBytes());
            System.out.println("==================>" + new String(simpleDistributedQueue.poll()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

    }
}
