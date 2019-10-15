package com.eagle.service;

/**
 * 创建时间: 2019/10/15,15:16
 * 工程师: EagleMao
 * 功效: 销售分成的桥接接口
 */
public interface DistrictPercentage {

    /**
     *  不同类型的提成不同
     *      type：
     *      suv
     *      car
     *
     * @param type
     */
    void salePercentage(String type);
}
