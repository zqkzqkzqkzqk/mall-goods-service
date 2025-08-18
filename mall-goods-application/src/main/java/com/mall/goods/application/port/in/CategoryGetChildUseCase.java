package com.mall.goods.application.port.in;

import com.mall.goods.application.dto.CategoryResponse;

import java.util.List;

/**
 * 获取子分类列表服务用例接口
 * @author zhangqiankai
 */
public interface CategoryGetChildUseCase {
    /**
     * 获取子分类列表
     *
     * @param parentId 父分类ID
     * @return 子分类列表
     */
    List<CategoryResponse> getChildCategories(Long parentId);
}
