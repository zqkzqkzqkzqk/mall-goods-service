package com.mall.goods.domain.service;

import com.mall.goods.domain.model.unit.UnitId;

/**
 * 单位领域服务
 * 处理单位相关的业务逻辑
 */
public interface UnitDomainService {
    
    /**
     * 检查单位名称是否重复
     * @param name 单位名称
     * @param excludeId 排除的单位ID
     * @return 是否重复
     */
    boolean isUnitNameDuplicate(String name, UnitId excludeId);
    
    /**
     * 检查是否可以删除单位
     * @param unitId 单位ID
     * @return 是否可以删除
     */
    boolean canDeleteUnit(UnitId unitId);
    
    /**
     * 验证单位名称格式
     * @param name 单位名称
     * @return 是否合法
     */
    boolean isValidUnitName(String name);
    
    /**
     * 验证排序值
     * @param sort 排序值
     * @return 是否合法
     */
    boolean isValidSort(Integer sort);
} 