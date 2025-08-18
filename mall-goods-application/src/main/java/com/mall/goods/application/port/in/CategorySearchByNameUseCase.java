package com.mall.goods.application.port.in;

import com.mall.goods.application.dto.CategoryResponse;

import java.util.List;

public interface CategorySearchByNameUseCase {
    /**
     * 根据名称搜索分类
     *
     * @param name 分类名称
     * @return 分类列表
     */
    List<CategoryResponse> searchCategoriesByName(String name);
}
