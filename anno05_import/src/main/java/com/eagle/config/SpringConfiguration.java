package com.eagle.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 创建时间: 2019/10/16,9:48
 * 工程师: EagleMao
 * 功效:
 */
@Configuration
@Import(JdbcConfig.class)
public class SpringConfiguration {
}
