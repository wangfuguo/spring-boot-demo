package com.fuguo.decorator;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-20 16:51
 * @since V1.0.0
 */
public class Decorator implements Sourceable {

    private Sourceable sourceable;

    public Decorator(Sourceable sourceable) {
        super();
        this.sourceable = sourceable;
    }

    @Override
    public void method() {
        System.out.println("before decorator");
        sourceable.method();
        System.out.println("after decorator");
    }
}
