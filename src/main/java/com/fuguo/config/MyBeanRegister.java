package com.fuguo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-23 13:10
 * @since V1.0.0
 */
@ConditionalOnClass(value = MyBeanClass.class)
@ConditionalOnMissingBean(value = MyBeanClass.class)
public class MyBeanRegister implements ImportBeanDefinitionRegistrar, InitializingBean, BeanFactoryAware, BeanNameAware {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AbstractBeanDefinition beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyBeanClass.class)
                .setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE).getBeanDefinition();
        MyBean annotation = (MyBean)MyBeanClass.class.getDeclaredAnnotation(MyBean.class);
        if(annotation != null) {
            if(StringUtils.isEmpty(annotation.name())) {
                registry.registerBeanDefinition(annotation.name(), beanDefinitionBuilder);
            }
        }
        registry.registerBeanDefinition("myBeanClass", beanDefinitionBuilder);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setBeanName(String name) {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
