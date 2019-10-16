package com.eagle.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 创建时间: 2019/10/16,9:01
 * 工程师: EagleMao
 * 功效:
 */
@Configuration
public class SpringConfiguration {

    @Resource
    private DataSource dataSource;

    /**
     *   创建有个数据源对象
     * @return
     */
    @Bean(value = "dataSource",autowireCandidate = false)
    public DataSource createDataSource() {
        return new DriverManagerDataSource();
    }

    /**
     *      创建jdbcTemplate对象
     * @return
     */
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate createJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }
}
