package com.fuguo.proxy;

import java.lang.reflect.Proxy;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-20 17:04
 * @since V1.0.0
 */
public class ProxyClient {
    public static void main(String[] args){

        Sourceable sourceable = new Source();
        Sourceable proxy = (Sourceable)Proxy.newProxyInstance(Sourceable.class.getClassLoader(),
                new Class[]{Sourceable.class}, new SourceProxy(sourceable));
        proxy.method();
        System.out.println();

    }
}
