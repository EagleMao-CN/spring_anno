package com.eagle;

import config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 创建时间: 2019/10/15,9:46
 * 工程师: EagleMao
 * 功效: 测试configuration注解
 */
public class SpringConfigurationTest {
    public static void main(String[] args) {
        //1.创建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");

        //2. 获取对象
        //2.1 通过字节码对象获取对象
//        SpringConfiguration springConfiguration = ac.getBean(SpringConfiguration.class);
        //2.2 根据bean 的name获取对象
        SpringConfiguration springConfiguration = ac.getBean("springConfiguration", SpringConfiguration.class);
        //3.输出结果
        System.out.println(springConfiguration);
    }
}
