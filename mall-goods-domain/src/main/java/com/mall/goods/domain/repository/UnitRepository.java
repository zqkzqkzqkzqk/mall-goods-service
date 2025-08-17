package com.mall.goods.domain.repository;

import com.mall.goods.domain.model.unit.Unit;
import com.mall.goods.domain.model.unit.UnitId;

import java.util.List;
import java.util.Optional;

/**
 * 单位仓储接口
 */
public interface UnitRepository {
    
    /**
     * 保存单位
     * @param unit 单位
     * @return 保存后的单位
     */
    Unit save(Unit unit);
    
    /**
     * 根据ID查找单位
     * @param unitId 单位ID
     * @return 单位
     */
    Optional<Unit> findById(UnitId unitId);
    
    /**
     * 查找所有单位
     * @return 单位列表
     */
    List<Unit> findAll();
    
    /**
     * 根据单位名称查找单位
     * @param name 单位名称
     * @return 单位
     */
    Optional<Unit> findByName(String name);
    
    /**
     * 删除单位
     * @param unitId 单位ID
     */
    void delete(UnitId unitId);
    
    /**
     * 检查单位名称是否存在
     * @param name 单位名称
     * @param excludeId 排除的单位ID
     * @return 是否存在
     */
    boolean existsByName(String name, UnitId excludeId);
    
    /**
     * 根据排序查找单位
     * @param sort 排序值
     * @return 单位列表
     */
    List<Unit> findBySort(Integer sort);
    
    /**
     * 根据单位名称模糊查询
     * @param name 单位名称
     * @return 单位列表
     */
    List<Unit> findByNameContaining(String name);
    
    /**
     * 批量保存单位
     * @param units 单位列表
     * @return 保存后的单位列表
     */
    List<Unit> saveAll(List<Unit> units);
} 