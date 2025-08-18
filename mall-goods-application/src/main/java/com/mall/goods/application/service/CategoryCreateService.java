package com.mall.goods.application.service;

import com.mall.goods.application.port.in.CategoryCreateUseCase;
import org.springframework.stereotype.Service;

@Service
public class CategoryCreateService implements CategoryCreateUseCase {
    @Override
    public Long createCategory(String name, Long parentId, Integer level, Boolean isShow, Integer sort, String icon, String description) {
        return 0L;
    }
}
