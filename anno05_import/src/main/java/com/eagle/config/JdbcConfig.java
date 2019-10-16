package com.eagle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * 创建时间: 2019/10/16,9:51
 * 工程师: EagleMao
 * 功效:
 */
public class JdbcConfig {

    /**
     *      创建数据源
     * @return
     */
    @Bean(value = "dataSource")
    public DataSource createDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/srping_ioc");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
}
