package com.eagle.service.northimpl;

import com.eagle.annotation.District;
import com.eagle.service.DistricPerformance;
import org.springframework.stereotype.Service;

/**
 * 创建时间: 2019/10/15,15:30
 * 工程师: EagleMao
 * 功效: 华北区绩效计算的实现
 */
@Service(value = "districPerformance")
@District(value = "north")
public class NorthDistricPerformance implements DistricPerformance {
    @Override
    public void cacPerformance(String type) {

        if ("suv".equalsIgnoreCase(type)) {
            System.out.println("华北区" + type + "绩效是3");
        } else if ("car".equalsIgnoreCase(type)) {
            System.out.println("华北区" + type + "绩效是5");
        }
    }
}
