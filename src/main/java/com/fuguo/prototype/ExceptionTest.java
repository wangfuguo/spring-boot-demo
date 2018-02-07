package com.fuguo.prototype;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-11 14:55
 * @since V1.0.0
 */
public class ExceptionTest {
    public static void main(String[] args){

        System.out.println();
        String suffix = "市";
        String name = "北京上海";
        if(name.endsWith(suffix)) {
            System.out.println(name.substring(0, name.indexOf(suffix)));
        } else {
            System.out.println(name + suffix);
        }
        //getException();

    }

    private static void getException() {
       double a = 10/0;
    }

}
