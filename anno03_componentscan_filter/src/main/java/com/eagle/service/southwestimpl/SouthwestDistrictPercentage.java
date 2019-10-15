package com.eagle.service.southwestimpl;

import com.eagle.annotation.District;
import com.eagle.service.DistrictPercentage;
import org.springframework.stereotype.Service;

/**
 * 创建时间: 2019/10/15,15:35
 * 工程师: EagleMao
 * 功效: 西南区分成的实现
 */
@Service(value = "districtPercentage")
@District(value = "south")
public class SouthwestDistrictPercentage implements DistrictPercentage{
    @Override
    public void salePercentage(String type) {
        if ("suv".equalsIgnoreCase(type)) {
            System.out.println("西南区" + type + "提成1.5%");
        } else if ("car".equalsIgnoreCase(type)) {
            System.out.println("西南区" + type + "提成0.5%");
        }
    }
}
