package com.fuguo.adapter.object;

import com.fuguo.adapter.Source;
import com.fuguo.adapter.Targetable;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-18 13:32
 * @since V1.0.0
 */
public class Test {

    public static void main(String[] args){

        Source source = new Source();
        Targetable targetable = new Wrapper(source);
        targetable.method1();
        targetable.method2();

    }
}
