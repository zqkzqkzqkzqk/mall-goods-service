package com.mall.goods.application.service;

import com.mall.goods.application.dto.CategoryResponse;
import com.mall.goods.application.port.in.CategorySearchByNameUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 根据名称搜索分类服务实现用例
 */
@Service
public class CategorySearchByNameService implements CategorySearchByNameUseCase {
    @Override
    public List<CategoryResponse> searchCategoriesByName(String name) {
        return List.of();
    }
}
