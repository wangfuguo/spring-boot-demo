package com.fuguo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-20 16:58
 * @since V1.0.0
 */
public class SourceProxy implements InvocationHandler {

    private Sourceable sourceable;

    public SourceProxy(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(sourceable, args);
    }
}
