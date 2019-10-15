package com.eagle.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建时间: 2019/10/15,15:12
 * 工程师: EagleMao
 * 功效: 定义区域的注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface District {

    /**
     * 用于指定区域名称
     * @return
     */
    String value();
}
