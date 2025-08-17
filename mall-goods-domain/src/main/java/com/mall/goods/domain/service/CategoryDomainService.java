package com.mall.goods.domain.service;

import com.mall.goods.domain.model.category.Category;
import com.mall.goods.domain.model.category.CategoryId;

import java.util.List;

/**
 * 分类领域服务
 * 处理分类相关的业务逻辑
 */
public interface CategoryDomainService {
    
    /**
     * 检查分类名称是否重复
     * @param categoryName 分类名称
     * @param parentId 父分类ID
     * @param excludeId 排除的分类ID
     * @return 是否重复
     */
    boolean isCategoryNameDuplicate(String categoryName, CategoryId parentId, CategoryId excludeId);
    
    /**
     * 获取分类的完整路径
     * @param categoryId 分类ID
     * @return 分类路径列表
     */
    List<Category> getCategoryPath(CategoryId categoryId);
    
    /**
     * 检查是否可以删除分类
     * @param categoryId 分类ID
     * @return 是否可以删除
     */
    boolean canDeleteCategory(CategoryId categoryId);
    
    /**
     * 获取分类的所有子分类
     * @param categoryId 分类ID
     * @return 子分类列表
     */
    List<Category> getSubCategories(CategoryId categoryId);
    
    /**
     * 计算分类层级深度
     * @param categoryId 分类ID
     * @return 层级深度
     */
    int calculateCategoryDepth(CategoryId categoryId);
    
    /**
     * 验证分类层级是否合法
     * @param parentId 父分类ID
     * @return 是否合法
     */
    boolean isValidCategoryLevel(CategoryId parentId);
} 