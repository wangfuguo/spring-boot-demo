package com.fuguo.controller;

import com.fuguo.config.MyBeanClass;
import com.fuguo.config.beanregistry.Man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-23 13:52
 * @since V1.0.0
 */
@RestController
public class TestController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public MyBeanClass myBeanClass;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private Man man;

    @RequestMapping("/getBeanName")
    public String getBeanName() {
        man.doSomething();
        return myBeanClass.getName();
    }
}
