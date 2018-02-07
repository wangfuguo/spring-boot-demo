package com.fuguo.adapter.itf;

import com.fuguo.adapter.Targetable;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-18 13:45
 * @since V1.0.0
 */
public class Test {

    public static void main(String[] args){

        Targetable targetable1 = new TargetSub1();
        Targetable targetable2 = new TargetSub2();
        targetable1.method1();
        targetable1.method2();
        targetable2.method1();
        targetable2.method2();
        System.out.println();

    }
}
