package com.eagle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 创建时间: 2019/10/16,9:09
 * 工程师: EagleMao
 * 功效:
 */
public class BeanTest {

    public static void main(String[] args) {
        //1.构建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("com.eagle.config");
        //2.获取对象
        DataSource dataSource = ac.getBean("dataSource",DataSource.class);
        //3.输出结果
        System.out.println(dataSource);

        //获取jdbcTemplate对象
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //输出结果
        System.out.println(jdbcTemplate.getDataSource());

    }
}
