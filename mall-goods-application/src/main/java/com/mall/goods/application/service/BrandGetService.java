package com.mall.goods.application.service;

import com.mall.goods.application.dto.BrandResponse;
import com.mall.goods.application.port.in.BrandGetUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 品牌获取服务实现用例
 * @author zhangqiankai
 */
@Service
public class BrandGetService implements BrandGetUseCase {
    @Override
    public Optional<BrandResponse> getBrand(Long id) {
        return Optional.empty();
    }
}
