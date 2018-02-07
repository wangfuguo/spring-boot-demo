package com.fuguo.decorator;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-20 16:51
 * @since V1.0.0
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("the source method.");
    }
}
