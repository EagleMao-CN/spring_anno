package com.eagle.service;

/**
 * 创建时间: 2019/10/15,15:20
 * 工程师: EagleMao
 * 功效:  绩效的桥接接口
 */
public interface DistricPerformance {

    /**
     *  根据车辆类型算绩效
     *  type：
     *      car
     *      suv
     * @param type
     */
    void cacPerformance(String type);
}
