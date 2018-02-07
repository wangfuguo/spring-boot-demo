package com.fuguo.adapter.object;

import com.fuguo.adapter.Source;
import com.fuguo.adapter.Targetable;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-18 13:30
 * @since V1.0.0
 */
public class Wrapper implements Targetable {

    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is target method");
    }
}
