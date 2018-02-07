package com.fuguo.proxy;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-20 17:03
 * @since V1.0.0
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is source method.");
    }
}
