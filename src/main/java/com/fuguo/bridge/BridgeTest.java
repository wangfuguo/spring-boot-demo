package com.fuguo.bridge;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-26 9:39
 * @since V1.0.0
 */
public class BridgeTest {
    public static void main(String[] args){

        Driver driver = new MysqlDriver();
        DriverManager driverManager = new DriverManager();
        driverManager.setDriver(driver);
        driverManager.getConnection("jdbc:mysql://localhost:3306/test");

    }
}
