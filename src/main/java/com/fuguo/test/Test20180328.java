package com.fuguo.test;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-28 8:36
 * @since V1.0.0
 */
public class Test20180328 {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    static {
        threadLocal.set(20);
    }

    public static void main(String[] args){
        Integer integer = threadLocal.get();
        System.out.println(integer);

    }
}
