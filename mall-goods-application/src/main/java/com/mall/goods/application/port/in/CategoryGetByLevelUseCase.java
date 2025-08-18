package com.mall.goods.application.port.in;

import com.mall.goods.application.dto.CategoryResponse;

import java.util.List;

/**
 * 根据层级获取分类列表服务用例接口
 * @author zhangqiankai
 */
public interface CategoryGetByLevelUseCase {
    /**
     * 根据层级获取分类列表
     *
     * @param level 层级
     * @return 分类列表
     */
    List<CategoryResponse> getCategoriesByLevel(Integer level);
}
