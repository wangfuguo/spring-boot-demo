package com.fuguo.decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-20 16:54
 * @since V1.0.0
 */
public class DecoratorTest {

    public static void main(String[] args){

        Sourceable sourceable = new Source();
        Sourceable obj = new Decorator(sourceable);
        obj.method();
        System.out.println(System.currentTimeMillis());
        List<String> list = new ArrayList<>();

        Comparator<String> strComp = new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };

        Collections.sort(list, strComp);

        java.security.AccessController.doPrivileged(
                new java.security.PrivilegedAction<Void>() {
                    @Override
                    public Void run() {
                        return null;
                    }
                });


    }

}
