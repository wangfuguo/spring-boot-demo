package com.fuguo.bridge;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-26 9:21
 * @since V1.0.0
 */
public class DB2Driver implements Driver {
    @Override
    public void getConnection(String url) {
        System.out.println("get DB2 Connection. url = " + url);
    }
}
