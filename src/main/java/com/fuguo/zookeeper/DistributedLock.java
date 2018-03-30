package com.fuguo.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-09 13:54
 * @since V1.0.0
 */
public class DistributedLock implements Lock, Watcher {

    private static final String SPLITSTR = "_lock_";
    private static final int SESSION_TIMEOUT = 60000;//等锁的毫秒数
    private static final byte[] data = new byte[0];

    private ZooKeeper zk = null;
    private String root = "/locks";//根
    private String lockName;//竞争资源的标志
    private String waitNode;//等待前一个锁
    private String myZnode;//当前锁
    private CountDownLatch latch;//计数器

    public DistributedLock(String server, String lockName) {
        this.lockName = lockName;
        try {
            zk = initZK(server);
            Stat stat = zk.exists(root, false);
            if(stat == null) {
                zk.create(root, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void lock() {
        try {
            if(!tryLock()) {
                boolean locked = waitForLock(waitNode, SESSION_TIMEOUT, TimeUnit.MILLISECONDS);
                if(!locked) {
                    System.out.println("can not lock...");
                }
            }
        } catch (Exception e) {
            new RuntimeException(e);
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        this.lock();
    }

    @Override
    public boolean tryLock() {
        try {
            if(lockName.contains(SPLITSTR)) {
                throw new RuntimeException("lockName can not contains \\u000B");
            }
            //创建临时子节点
            myZnode = zk.create(root + "/" + lockName, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            //取出所有子节点
            List<String> subNodes = zk.getChildren(root, false);
            //取出所有lockName的锁
            List<String> lockObjNodes = new ArrayList<>();
            for (String node : subNodes) {
                String _node = node.split(SPLITSTR)[0];
                if(_node.equals(lockName)){
                    lockObjNodes.add(node);
                }
            }
            Collections.sort(lockObjNodes);
            if(myZnode.equals(root+"/"+lockObjNodes.get(0))){
                //如果是最小的节点,则表示取得锁
                return true;
            }
            //如果不是最小的节点，找到比自己小1的节点
            String subMyZnode = myZnode.substring(myZnode.lastIndexOf("/") + 1);
            waitNode = lockObjNodes.get(Collections.binarySearch(lockObjNodes, subMyZnode) - 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        try {
            return tryLock() || waitForLock(waitNode, time, unit);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void unlock() {
        try {
            zk.delete(myZnode,-1);
            myZnode = null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if(this.latch != null) {
            this.latch.countDown();
        }
    }

    private synchronized ZooKeeper initZK(String server) {
        try {
            if(zk == null) {
                zk = new ZooKeeper(server, SESSION_TIMEOUT, this);
            }
        } catch (Exception e) {
            throw new RuntimeException("zk init connect fail.", e);
        }
        return zk;
    }

    private boolean waitForLock(String lower, long waitTime, TimeUnit unit) throws KeeperException,
            InterruptedException {
        Stat stat = zk.exists(root + "/" + lower, true);
        if(stat != null) {
            this.latch = new CountDownLatch(1);
            this.latch.await(waitTime, unit);
            this.latch = null;
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {

        DistributedLock distributedLock = new DistributedLock("127.0.0.1:2181", "account");
        distributedLock.lock();
        Thread.sleep(5000);
        distributedLock.unlock();
        System.out.println();

    }
}
