package com.mall.goods.application.port.in;

import com.mall.goods.application.dto.BrandResponse;

import java.util.Optional;

public interface BrandGetUseCase {
    /**
     * 获取品牌详情
     *
     * @param id 品牌ID
     * @return 品牌详情
     */
    Optional<BrandResponse> getBrand(Long id);
}
