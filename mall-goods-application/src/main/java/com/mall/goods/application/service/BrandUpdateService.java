package com.mall.goods.application.service;

import com.mall.goods.application.command.CreateBrandCommand;
import com.mall.goods.application.port.in.BrandUpdateUseCase;
import org.springframework.stereotype.Service;

/**
 * 品牌更新服务实现用例
 */
@Service
public class BrandUpdateService implements BrandUpdateUseCase {
    @Override
    public void updateBrand(Long id, CreateBrandCommand command) {

    }
}
