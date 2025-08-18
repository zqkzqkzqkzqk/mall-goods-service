package com.mall.goods.application.service;

import com.mall.goods.application.dto.CategoryResponse;
import com.mall.goods.application.port.in.CategoryGetByLevelUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryGetByLevelService implements CategoryGetByLevelUseCase {
    @Override
    public List<CategoryResponse> getCategoriesByLevel(Integer level) {
        return List.of();
    }
}
