package com.fuguo.config;

import java.lang.annotation.*;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-23 13:23
 * @since V1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyBean {

    String name();
}
