package com.eagle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * 创建时间: 2019/10/16,9:49
 * 工程师: EagleMao
 * 功效:
 */
public class ImportTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("com.eagle.config");
        DataSource dataSource = ac.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);


    }
}
