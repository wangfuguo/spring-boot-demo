package com.fuguo.bridge;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-26 9:19
 * @since V1.0.0
 */
public class MysqlDriver implements Driver {
    @Override
    public void getConnection(String url) {
        System.out.println("get Mysql Connection. url = " + url);
    }
}
