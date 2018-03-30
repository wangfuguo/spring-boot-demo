package com.fuguo.config.autowire;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Configuration;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-28 16:05
 * @since V1.0.0
 */
@Configuration
public class TestBeanRegistryAnno implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware {

    protected ApplicationContext applicationContext;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    private class AnnotationScanner extends ClassPathBeanDefinitionScanner {

        public AnnotationScanner(BeanDefinitionRegistry registry) {
            super(registry);
        }


    }

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws
            BeansException {
        this.applicationContext = applicationContext;
    }
}
