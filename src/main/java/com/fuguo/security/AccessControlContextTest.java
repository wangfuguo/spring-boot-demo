package com.fuguo.security;

import org.springframework.beans.factory.support.SecurityContextProvider;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-19 9:43
 * @since V1.0.0
 */
public class AccessControlContextTest {

    private static SecurityContextProvider securityContextProvider;

    public static void main(String[] args){

        Pear pear = AccessController.doPrivileged(new PrivilegedAction<Pear>() {
            @Override
            public Pear run() {
                return new Pear();
            }
        }, getAccessControlContext());
        System.out.println(pear.id);

    }

    public static AccessControlContext getAccessControlContext() {
        return (securityContextProvider != null ?
                securityContextProvider.getAccessControlContext() :
                AccessController.getContext());
    }
}
class Pear {
    public int id = 1001;
}
