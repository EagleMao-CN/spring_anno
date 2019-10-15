package com.eagle.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.eagle.service.UserService;

/**
 * 创建时间: 2019/10/15,10:30
 * 工程师: EagleMao
 * 功效: spring的配置类
 */
@Configuration
//@ComponentScan(value = "service") value 和basePackages 都可用
//@ComponentScan(basePackages = "service")
@ComponentScan(basePackageClasses = UserService.class)  //该类所在的包及其子包都会被扫描
public class SpringConfiguration {
}
