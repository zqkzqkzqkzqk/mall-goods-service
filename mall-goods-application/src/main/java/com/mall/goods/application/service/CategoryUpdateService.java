package com.mall.goods.application.service;

import com.mall.goods.application.port.in.CategoryUpdateUseCase;
import org.springframework.stereotype.Service;

/**
 * 分类更新服务实现用例
 * @author zhangqiankai
 */
@Service
public class CategoryUpdateService implements CategoryUpdateUseCase {
    @Override
    public void updateCategory(Long id, String name, Long parentId, Integer level, Boolean isShow, Integer sort, String icon, String description) {

    }
}
