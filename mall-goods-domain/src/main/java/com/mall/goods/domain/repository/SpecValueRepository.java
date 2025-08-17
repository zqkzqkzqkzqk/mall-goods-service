package com.mall.goods.domain.repository;

import com.mall.goods.domain.model.spec.SpecValue;
import com.mall.goods.domain.model.spec.SpecValueId;
import com.mall.goods.domain.model.spec.SpecId;

import java.util.List;
import java.util.Optional;

/**
 * 规格值仓储接口
 */
public interface SpecValueRepository {
    
    /**
     * 保存规格值
     * @param specValue 规格值
     * @return 保存后的规格值
     */
    SpecValue save(SpecValue specValue);
    
    /**
     * 根据ID查找规格值
     * @param specValueId 规格值ID
     * @return 规格值
     */
    Optional<SpecValue> findById(SpecValueId specValueId);
    
    /**
     * 根据规格ID查找规格值列表
     * @param specId 规格ID
     * @return 规格值列表
     */
    List<SpecValue> findBySpecId(SpecId specId);
    
    /**
     * 根据规格值名称查找规格值
     * @param specValueName 规格值名称
     * @param specId 规格ID
     * @return 规格值
     */
    Optional<SpecValue> findBySpecValueNameAndSpecId(String specValueName, SpecId specId);
    
    /**
     * 删除规格值
     * @param specValueId 规格值ID
     */
    void delete(SpecValueId specValueId);
    
    /**
     * 根据规格ID删除所有规格值
     * @param specId 规格ID
     */
    void deleteBySpecId(SpecId specId);
    
    /**
     * 批量保存规格值
     * @param specValues 规格值列表
     * @return 保存后的规格值列表
     */
    List<SpecValue> saveAll(List<SpecValue> specValues);
    
    /**
     * 检查规格值名称是否存在
     * @param specValueName 规格值名称
     * @param specId 规格ID
     * @param excludeId 排除的规格值ID
     * @return 是否存在
     */
    boolean existsBySpecValueNameAndSpecId(String specValueName, SpecId specId, SpecValueId excludeId);
    
    /**
     * 根据规格值名称模糊查询
     * @param specValueName 规格值名称
     * @param specId 规格ID
     * @return 规格值列表
     */
    List<SpecValue> findBySpecValueNameContainingAndSpecId(String specValueName, SpecId specId);
    
    /**
     * 根据多个规格ID查找规格值
     * @param specIds 规格ID列表
     * @return 规格值列表
     */
    List<SpecValue> findBySpecIdIn(List<SpecId> specIds);
} 