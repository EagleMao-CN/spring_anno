package com.eagle.service.southwestimpl;

import com.eagle.annotation.District;
import com.eagle.service.DistricPerformance;
import org.springframework.stereotype.Service;

/**
 * 创建时间: 2019/10/15,15:37
 * 工程师: EagleMao
 * 功效: 西南区绩效的实现
 */
@Service(value = "districPerformance")
@District(value = "south")
public class SouthwestDistricperformance implements DistricPerformance {
    @Override
    public void cacPerformance(String type) {

        if ("suv".equalsIgnoreCase(type)) {
            System.out.println("西南区" + type + "绩效是5");
        } else if ("car".equalsIgnoreCase(type)) {
            System.out.println("西南区" + type + "绩效是3");
        }
    }
}
