package com.mall.goods.application.service;

import com.mall.goods.application.dto.CategoryResponse;
import com.mall.goods.application.port.in.CategoryGetUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryGetService implements CategoryGetUseCase {
    @Override
    public Optional<CategoryResponse> getCategory(Long id) {
        return Optional.empty();
    }
}
