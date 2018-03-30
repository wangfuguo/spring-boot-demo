package com.fuguo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-19 16:32
 * @since V1.0.0
 */
@Configuration
public class MyConfig {

    public final static String _a = "abc";
    public final static String __a = "abc";
    public static String _b = "b";
    public String _c = "c";

    @Bean
    public Fruit fruit() {
        String ta = "ad";
        String tb = "abc";
        Fruit apple = new Apple();
        return apple;
    }
}

interface Fruit {

}

class Apple implements Fruit {

}
