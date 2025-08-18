package com.mall.goods.application.port.in;

import com.mall.goods.application.dto.CategoryResponse;

import java.util.List;

/**
 * 获取分类树列表服务用例接口
 * @author zhangqiankai
 */
public interface CategoryGetTreeUseCase {
    /**
     * 获取分类树
     *
     * @return 分类树
     */
    List<CategoryResponse> getCategoryTree();
}
