package com.fuguo.bridge;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-26 9:22
 * @since V1.0.0
 */
public class DriverManager {

    private Driver driver;

    public void getConnection(String url) {
        driver.getConnection(url);
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
