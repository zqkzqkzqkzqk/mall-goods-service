package com.mall.goods.application.service;

import com.mall.goods.application.dto.CategoryResponse;
import com.mall.goods.application.port.in.CategoryGetChildUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryGetChildService implements CategoryGetChildUseCase {
    @Override
    public List<CategoryResponse> getChildCategories(Long parentId) {
        return List.of();
    }
}
