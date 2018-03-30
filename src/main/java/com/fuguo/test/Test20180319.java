package com.fuguo.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-19 16:00
 * @since V1.0.0
 */
public class Test20180319 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Calendar.getInstance().getTimeInMillis());
        Thread.sleep(20000);
        System.out.println("begin ...");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            StringBuilder sb = new StringBuilder("google amazon apple facebook microsoft" + i);
            list.add(sb.toString());
        }
        Apple apple = new Apple(list);
        System.out.println(apple.hashCode());
        Thread.sleep(10000);
        apple = null;
        System.out.println("begin gc...");
        System.gc();
        Thread.sleep(5000);
        System.out.println("over");

    }
}

class Apple {
    public List<String> list = new ArrayList<>();

    public Apple(List<String> list) {
        this.list = list;
    }
}
