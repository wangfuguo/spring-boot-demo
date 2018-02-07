package com.fuguo.adapter.clazz;

import com.fuguo.adapter.Source;
import com.fuguo.adapter.Targetable;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-18 13:21
 * @since V1.0.0
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is target method");
    }
}
