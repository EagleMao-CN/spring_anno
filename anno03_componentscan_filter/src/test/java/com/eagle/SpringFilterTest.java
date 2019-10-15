package com.eagle;

import com.eagle.service.DistricPerformance;
import com.eagle.service.DistrictPercentage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 创建时间: 2019/10/15,15:43
 * 工程师: EagleMao
 * 功效: 测试
 */
public class SpringFilterTest {

    public static void main(String[] args) {
        //1.创建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");

        //2.获取bean对象
        DistrictPercentage districtPercentage = ac.getBean("districtPercentage" , DistrictPercentage.class);

        //3.执行方法
        districtPercentage.salePercentage("suv");


        //2.1.获取bean对象
        DistricPerformance districPerformance = ac.getBean("districPerformance",DistricPerformance.class);

        //3.1.执行方法
        districPerformance.cacPerformance("suv");
    }
}
