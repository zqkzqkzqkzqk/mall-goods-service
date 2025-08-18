package com.mall.goods.application.port.in;

public interface CategoryDeleteUseCase {
    /**
     * 删除分类
     *
     * @param id 分类ID
     */
    void deleteCategory(Long id);
}
