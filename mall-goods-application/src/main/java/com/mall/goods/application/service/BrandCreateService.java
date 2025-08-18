package com.mall.goods.application.service;

import com.mall.goods.application.command.CreateBrandCommand;
import com.mall.goods.application.port.in.BrandCreateUseCase;
import org.springframework.stereotype.Service;

/**
 * 品牌创建服务实现用例
 * @author zhangqiankai
 */
@Service
public class BrandCreateService implements BrandCreateUseCase {
    @Override
    public Long createBrand(CreateBrandCommand command) {
        return 0L;
    }
}
