package com.mall.goods.application.port.in;

import com.mall.goods.application.dto.BrandResponse;

import java.util.List;

public interface BrandSearchByNameUseCase {
    /**
     * 根据名称搜索品牌
     *
     * @param name 品牌名称
     * @return 品牌列表
     */
    List<BrandResponse> searchBrandsByName(String name);
}
