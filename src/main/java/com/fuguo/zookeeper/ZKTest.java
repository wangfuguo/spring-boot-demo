package com.fuguo.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.File;
import java.util.List;

import static org.apache.zookeeper.ZooDefs.Ids;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-18 16:48
 * @since V1.0.0
 */
public class ZKTest {
    private ZooKeeper zk = null;

    private void init() throws Exception {
        zk = new ZooKeeper("127.0.0.1:2181", 2000, new Watcher() {
            /**
             * 监听事件发生时的回调方法
             */
            @Override
            public void process(WatchedEvent event) {
                if (event.getType() == Event.EventType.None) {
                    System.out.println("Event:null");
                    return;
                }
                System.out.println("EventType:" + event.getType());
                System.out.println("Path" + event.getPath());

                try {
                    zk.getData("/nodes1", true, null);
                    zk.getChildren("/nodes1", true);

                } catch (KeeperException | InterruptedException e) {

                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 向zookeeper服务(集群)中注册数据，添加znode
     * @throws Exception
     */

    public void testCreateZnode() throws Exception {
        zk.create("/nodes1", "nodes1".getBytes("utf-8"),
                Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        // 在一个父节点的范围之内,sequential的顺序是递增的
        zk.create("/nodes1/testNode1", "/nodes1/testNode1".getBytes("utf-8"),
                Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        zk.create("/nodes1/testNode2", "/nodes1/testNode2".getBytes("utf-8"),
                Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);

        // 换一个父节点，序号的递增顺序重新开始
        zk.create("/nodes2", "nodes2".getBytes("utf-8"),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create("/nodes2/testNode1", "/nodes2/testNode1".getBytes("utf-8"),
                Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);

        zk.create("/nodes3", "/nodes3".getBytes("utf-8"),
                Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        zk.close();
    }

    /**
     * 从zookeeper中删除znode
     * @throws Exception
     */
    public void testDeleteZnode() throws Exception {

        // 参数1：要删除的节点的路径 参数2：要删除的节点的版本，-1匹配所有版本
        // 只能删除不为空的节点
        zk.delete("/nodes3", -1);
        Stat exists = zk.exists("/nodes3", false);
        System.out.println(exists);

    }

    public void testUpdateZnode() throws Exception {
        byte[] data = zk.getData("/nodes1", false, null);
        System.out.println(new String(data, "utf-8"));

        zk.setData("/nodes1", "/nodes1 data changed".getBytes("utf-8"), -1);

        data = zk.getData("/nodes1", false, null);
        System.out.println(new String(data, "utf-8"));

    }

    /**
     * 获取子节点信息
     * @throws Exception
     */
    public void testGetChildren() throws Exception {
        List<String> children = zk.getChildren("/nodes1", false);
        for (String child : children) {
            System.out.println(child);
        }
    }

    /**
     * zk的监听机制：
     * 在初始化zk对象的时候定义好回调函数，对znode进行操作时可以注册监听
     * 监听的znode上发生相应事件时，客户端zk会接收到zookeeper的事件通知
     * 客户端zk根据事件调用我们事先定义好的回调函数
     * @throws Exception
     *
     */
    public void testWatch() throws Exception {
        //获取/nodes1的数据时进行监听
        //第二个参数true表示监听
        byte[] data = zk.getData("/nodes1", true, null);

        //获取/nodes1的子节点时进行监听
        List<String> children = zk.getChildren("/nodes1", true);
        Thread.sleep(Long.MAX_VALUE);
    }


    /**
     * 将配置文件上传到zookeeper中进行管理
     * @throws Exception
     */
    public void testUploadConfigFileToZookeeper() throws Exception{
        String schema_xml = org.apache.commons.io.FileUtils.readFileToString(new File("c:/web.xml"));
        zk.create("/conf", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create("/conf/web.xml", schema_xml.getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.close();
    }

    public static void main(String[] args) throws Exception {
        ZKTest zkTest = new ZKTest();
        zkTest.init();
        zkTest.testGetChildren();
        System.out.println();

    }
}
