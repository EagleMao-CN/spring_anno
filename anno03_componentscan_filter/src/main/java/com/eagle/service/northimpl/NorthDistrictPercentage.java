package com.eagle.service.northimpl;

import com.eagle.annotation.District;
import com.eagle.service.DistrictPercentage;
import org.springframework.stereotype.Service;

/**
 * 创建时间: 2019/10/15,15:23
 * 工程师: EagleMao
 * 功效:  华北区的分成实现
 */
@Service(value = "districtPercentage")
@District(value = "north")
public class NorthDistrictPercentage implements DistrictPercentage{
    @Override
    public void salePercentage(String type) {

        if ("suv".equalsIgnoreCase(type)) {
            System.out.println("华北区" + type + "提成1%");
        } else if ("car".equalsIgnoreCase(type)) {
            System.out.println("华北区" + type + "提成0.5%");
        }
    }
}
