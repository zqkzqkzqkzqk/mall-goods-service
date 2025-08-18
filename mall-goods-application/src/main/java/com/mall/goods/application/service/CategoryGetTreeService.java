package com.mall.goods.application.service;

import com.mall.goods.application.dto.CategoryResponse;
import com.mall.goods.application.port.in.CategoryGetTreeUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 获取分类树列表服务实现用例
 * @author zhangqiankai
 */
@Service
public class CategoryGetTreeService implements CategoryGetTreeUseCase {
    @Override
    public List<CategoryResponse> getCategoryTree() {
        return List.of();
    }
}
