package com.mall.goods.domain.repository;

import com.mall.goods.domain.model.spec.Spec;
import com.mall.goods.domain.model.spec.SpecId;

import java.util.List;
import java.util.Optional;

/**
 * 规格仓储接口
 */
public interface SpecRepository {
    
    /**
     * 保存规格
     * @param spec 规格
     * @return 保存后的规格
     */
    Spec save(Spec spec);
    
    /**
     * 根据ID查找规格
     * @param specId 规格ID
     * @return 规格
     */
    Optional<Spec> findById(SpecId specId);
    
    /**
     * 查找所有规格
     * @return 规格列表
     */
    List<Spec> findAll();
    
    /**
     * 根据店铺ID查找规格列表
     * @param storeId 店铺ID
     * @return 规格列表
     */
    List<Spec> findByStoreId(Long storeId);
    
    /**
     * 根据规格名称查找规格
     * @param specName 规格名称
     * @param storeId 店铺ID
     * @return 规格
     */
    Optional<Spec> findBySpecNameAndStoreId(String specName, Long storeId);
    
    /**
     * 删除规格
     * @param specId 规格ID
     */
    void delete(SpecId specId);
    
    /**
     * 检查规格名称是否存在
     * @param specName 规格名称
     * @param storeId 店铺ID
     * @param excludeId 排除的规格ID
     * @return 是否存在
     */
    boolean existsBySpecNameAndStoreId(String specName, Long storeId, SpecId excludeId);
    
    /**
     * 批量保存规格
     * @param specs 规格列表
     * @return 保存后的规格列表
     */
    List<Spec> saveAll(List<Spec> specs);
    
    /**
     * 根据规格名称模糊查询
     * @param specName 规格名称
     * @param storeId 店铺ID
     * @return 规格列表
     */
    List<Spec> findBySpecNameContainingAndStoreId(String specName, Long storeId);
} 