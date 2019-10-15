package com.eagle.customer;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * 创建时间: 2019/10/15,11:28
 * 工程师: EagleMao
 * 功效:
 */
public class CustomerBeanNameGenerator implements BeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        //1.判断bean的定义信息是否是注解的
        if (definition instanceof AnnotatedBeanDefinition) {

        }

        return null;
    }
}
