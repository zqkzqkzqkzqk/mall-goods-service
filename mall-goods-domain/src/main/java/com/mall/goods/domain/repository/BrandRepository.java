package com.mall.goods.domain.repository;

import com.mall.goods.domain.model.brand.Brand;
import com.mall.goods.domain.model.brand.BrandId;

import java.util.List;
import java.util.Optional;

/**
 * 品牌仓储接口
 */
public interface BrandRepository {
    
    /**
     * 保存品牌
     * @param brand 品牌
     * @return 保存后的品牌
     */
    Brand save(Brand brand);
    
    /**
     * 根据ID查找品牌
     * @param brandId 品牌ID
     * @return 品牌
     */
    Optional<Brand> findById(BrandId brandId);
    
    /**
     * 查找所有品牌
     * @return 品牌列表
     */
    List<Brand> findAll();
    
    /**
     * 根据品牌名称查找品牌
     * @param brandName 品牌名称
     * @return 品牌
     */
    Optional<Brand> findByBrandName(String brandName);
    
    /**
     * 根据品牌英文名查找品牌
     * @param brandEnglish 品牌英文名
     * @return 品牌
     */
    Optional<Brand> findByBrandEnglish(String brandEnglish);
    
    /**
     * 根据店铺ID查找品牌列表
     * @param storeId 店铺ID
     * @return 品牌列表
     */
    List<Brand> findByStoreId(Long storeId);
    
    /**
     * 删除品牌
     * @param brandId 品牌ID
     */
    void delete(BrandId brandId);
    
    /**
     * 检查品牌名称是否存在
     * @param brandName 品牌名称
     * @param excludeId 排除的品牌ID
     * @return 是否存在
     */
    boolean existsByBrandName(String brandName, BrandId excludeId);
    
    /**
     * 检查品牌英文名是否存在
     * @param brandEnglish 品牌英文名
     * @param excludeId 排除的品牌ID
     * @return 是否存在
     */
    boolean existsByBrandEnglish(String brandEnglish, BrandId excludeId);
    
    /**
     * 检查品牌是否有关联的商品
     * @param brandId 品牌ID
     * @return 是否有关联商品
     */
    boolean hasRelatedGoods(BrandId brandId);
    
    /**
     * 查找推荐品牌
     * @return 推荐品牌列表
     */
    List<Brand> findRecommendBrands();
    
    /**
     * 根据申请状态查找品牌
     * @param applyState 申请状态
     * @return 品牌列表
     */
    List<Brand> findByApplyState(Integer applyState);
    
    /**
     * 根据品牌首字母查找品牌
     * @param brandInitial 品牌首字母
     * @return 品牌列表
     */
    List<Brand> findByBrandInitial(String brandInitial);
} 