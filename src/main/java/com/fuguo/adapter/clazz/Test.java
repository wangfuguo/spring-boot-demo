package com.fuguo.adapter.clazz;

import com.fuguo.adapter.Targetable;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-18 13:22
 * @since V1.0.0
 */
public class Test {

    public static void main(String[] args){

        Targetable targetable = new Adapter();
        targetable.method1();
        targetable.method2();

    }
}
