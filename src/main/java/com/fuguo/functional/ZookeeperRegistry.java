package com.fuguo.functional;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-20 15:59
 * @since V1.0.0
 */
public class ZookeeperRegistry {

    ZookeeperClient zookeeperClient;

    public ZookeeperRegistry() {
        zookeeperClient.addStateListener(connected -> {

        });
    }
}
