package com.fuguo.simplefactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author 00938658-王富国
 * @description:
 * @date 2018-02-09 10:57
 * @since V1.0.0
 */
public class Factory {

    private static Logger logger = LoggerFactory.getLogger(Factory.class);

    public static Api createApi() {
        Properties properties = new Properties();
        try {
            InputStream resourceAsStream = Factory.class.getResourceAsStream("/factorym.properties");
            properties.load(resourceAsStream);
            String property = System.getProperty("user.dir");
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/factorym.properties");
            if(fis !=null){
                properties.load(fis);
            }
        } catch (Exception e) {
            logger.error("加载配置文件出错!", e);
            e.printStackTrace();
        }
        try {
            return (Api) Class.forName(properties.getProperty("implClass")).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
