package com.mall.goods.application.port.in;

import com.mall.goods.application.dto.CategoryResponse;

import java.util.List;
import java.util.Optional;

/**
 * 分类用例接口
 */
public interface CategoryUseCase {
    
    /**
     * 创建分类
     *
     * @param name 分类名称
     * @param parentId 父分类ID
     * @param level 分类层级
     * @param isShow 是否显示
     * @param sort 排序
     * @param icon 图标
     * @param description 分类描述
     * @return 分类ID
     */
    Long createCategory(String name, Long parentId, Integer level, Boolean isShow, Integer sort, String icon, String description);
    
    /**
     * 更新分类
     *
     * @param id 分类ID
     * @param name 分类名称
     * @param parentId 父分类ID
     * @param level 分类层级
     * @param isShow 是否显示
     * @param sort 排序
     * @param icon 图标
     * @param description 分类描述
     */
    void updateCategory(Long id, String name, Long parentId, Integer level, Boolean isShow, Integer sort, String icon, String description);
    
    /**
     * 删除分类
     *
     * @param id 分类ID
     */
    void deleteCategory(Long id);
    
    /**
     * 获取分类详情
     *
     * @param id 分类ID
     * @return 分类详情
     */
    Optional<CategoryResponse> getCategory(Long id);
    
    /**
     * 获取分类树
     *
     * @return 分类树
     */
    List<CategoryResponse> getCategoryTree();
    
    /**
     * 获取子分类列表
     *
     * @param parentId 父分类ID
     * @return 子分类列表
     */
    List<CategoryResponse> getChildCategories(Long parentId);
    
    /**
     * 根据层级获取分类列表
     *
     * @param level 层级
     * @return 分类列表
     */
    List<CategoryResponse> getCategoriesByLevel(Integer level);

    /**
     * 根据名称搜索分类
     *
     * @param name 分类名称
     * @return 分类列表
     */
    List<CategoryResponse> searchCategoriesByName(String name);
}
