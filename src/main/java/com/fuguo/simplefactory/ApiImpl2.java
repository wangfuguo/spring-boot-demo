package com.fuguo.simplefactory;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-02-09 13:54
 * @since V1.0.0
 */
public class ApiImpl2 implements Api {
    @Override
    public void operation(String s) {
        System.out.println("ImplApi2 s==" + s);
    }
}
