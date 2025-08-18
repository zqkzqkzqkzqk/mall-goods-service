package com.mall.goods.application.port.in;

import com.mall.goods.application.dto.BrandResponse;

import java.util.List;

/**
 * 品牌列表服务用例接口
 */
public interface BrandListUseCase {
    /**
     * 获取品牌列表
     *
     * @return 品牌列表
     */
    List<BrandResponse> listBrands();
}
