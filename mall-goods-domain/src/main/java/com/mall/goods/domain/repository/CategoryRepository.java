package com.mall.goods.domain.repository;

import com.mall.goods.domain.model.category.Category;
import com.mall.goods.domain.model.category.CategoryId;

import java.util.List;
import java.util.Optional;

/**
 * 分类仓储接口
 */
public interface CategoryRepository {
    
    /**
     * 保存分类
     * @param category 分类
     * @return 保存后的分类
     */
    Category save(Category category);
    
    /**
     * 根据ID查找分类
     * @param categoryId 分类ID
     * @return 分类
     */
    Optional<Category> findById(CategoryId categoryId);
    
    /**
     * 查找所有顶级分类
     * @return 顶级分类列表
     */
    List<Category> findTopLevelCategories();
    
    /**
     * 根据父分类ID查找子分类
     * @param parentId 父分类ID
     * @return 子分类列表
     */
    List<Category> findByParentId(CategoryId parentId);
    
    /**
     * 根据分类名称查找分类
     * @param categoryName 分类名称
     * @param parentId 父分类ID
     * @return 分类
     */
    Optional<Category> findByCategoryNameAndParentId(String categoryName, CategoryId parentId);
    
    /**
     * 删除分类
     * @param categoryId 分类ID
     */
    void delete(CategoryId categoryId);
    
    /**
     * 检查分类名称是否存在
     * @param categoryName 分类名称
     * @param parentId 父分类ID
     * @param excludeId 排除的分类ID
     * @return 是否存在
     */
    boolean existsByCategoryNameAndParentId(String categoryName, CategoryId parentId, CategoryId excludeId);
    
    /**
     * 检查分类是否有子分类
     * @param categoryId 分类ID
     * @return 是否有子分类
     */
    boolean hasSubCategories(CategoryId categoryId);
    
    /**
     * 检查分类是否有关联的商品
     * @param categoryId 分类ID
     * @return 是否有关联商品
     */
    boolean hasRelatedGoods(CategoryId categoryId);
    
    /**
     * 获取分类树结构
     * @return 分类树
     */
    List<Category> getCategoryTree();
    
    /**
     * 根据层级查找分类
     * @param deep 层级深度
     * @return 分类列表
     */
    List<Category> findByDeep(Integer deep);
} 