package com.fuguo.config.autowire;

import org.springframework.stereotype.Component;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-28 16:03
 * @since V1.0.0
 */
@Component
public @interface TestCreateBean {

    /**
     * bean name
     */
    String value();
}
