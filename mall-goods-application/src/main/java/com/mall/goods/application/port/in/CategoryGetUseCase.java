package com.mall.goods.application.port.in;

import com.mall.goods.application.dto.CategoryResponse;

import java.util.Optional;

public interface CategoryGetUseCase {
    /**
     * 获取分类详情
     *
     * @param id 分类ID
     * @return 分类详情
     */
    Optional<CategoryResponse> getCategory(Long id);
}
