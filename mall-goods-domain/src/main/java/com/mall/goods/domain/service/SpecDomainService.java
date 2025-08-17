package com.mall.goods.domain.service;

import com.mall.goods.domain.model.spec.SpecId;

/**
 * 规格领域服务
 * 处理规格相关的业务逻辑
 */
public interface SpecDomainService {
    
    /**
     * 检查规格名称是否重复
     * @param specName 规格名称
     * @param storeId 店铺ID
     * @param excludeId 排除的规格ID
     * @return 是否重复
     */
    boolean isSpecNameDuplicate(String specName, Long storeId, SpecId excludeId);
    
    /**
     * 检查规格值名称是否重复
     * @param specValueName 规格值名称
     * @param specId 规格ID
     * @return 是否重复
     */
    boolean isSpecValueNameDuplicate(String specValueName, SpecId specId);
    
    /**
     * 检查是否可以删除规格
     * @param specId 规格ID
     * @return 是否可以删除
     */
    boolean canDeleteSpec(SpecId specId);
    
    /**
     * 验证规格名称格式
     * @param specName 规格名称
     * @return 是否合法
     */
    boolean isValidSpecName(String specName);
    
    /**
     * 验证规格值名称格式
     * @param specValueName 规格值名称
     * @return 是否合法
     */
    boolean isValidSpecValueName(String specValueName);
} 