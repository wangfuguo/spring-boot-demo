package com.fuguo.simplefactory;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-02-09 10:56
 * @since V1.0.0
 */
public class ApiImpl implements Api {
    @Override
    public void operation(String s) {
        System.out.println("ImplApi s==" + s);
    }
}
