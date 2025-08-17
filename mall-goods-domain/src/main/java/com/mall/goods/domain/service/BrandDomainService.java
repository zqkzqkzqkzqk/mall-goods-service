package com.mall.goods.domain.service;

import com.mall.goods.domain.model.brand.BrandId;

/**
 * 品牌领域服务
 * 处理品牌相关的业务逻辑
 */
public interface BrandDomainService {
    
    /**
     * 检查品牌名称是否重复
     * @param brandName 品牌名称
     * @param excludeId 排除的品牌ID
     * @return 是否重复
     */
    boolean isBrandNameDuplicate(String brandName, BrandId excludeId);
    
    /**
     * 检查品牌英文名是否重复
     * @param brandEnglish 品牌英文名
     * @param excludeId 排除的品牌ID
     * @return 是否重复
     */
    boolean isBrandEnglishDuplicate(String brandEnglish, BrandId excludeId);
    
    /**
     * 检查是否可以删除品牌
     * @param brandId 品牌ID
     * @return 是否可以删除
     */
    boolean canDeleteBrand(BrandId brandId);
    
    /**
     * 验证品牌申请状态
     * @param brandId 品牌ID
     * @return 是否通过审核
     */
    boolean isBrandApproved(BrandId brandId);
    
    /**
     * 验证品牌名称格式
     * @param brandName 品牌名称
     * @return 是否合法
     */
    boolean isValidBrandName(String brandName);
    
    /**
     * 验证品牌英文名格式
     * @param brandEnglish 品牌英文名
     * @return 是否合法
     */
    boolean isValidBrandEnglish(String brandEnglish);
} 