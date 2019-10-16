package com.eagle.config;

import com.eagle.importselector.CustomImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 创建时间: 2019/10/16,15:57
 * 工程师: EagleMao
 * 功效:
 */
@Configuration
@Import(CustomImportSelector.class)
public class SpringConfiguration {
}
