package com.mall.goods.application.port.in;

import com.mall.goods.application.dto.GoodsResponse;

import java.util.Optional;

public interface GoodsGetUseCase {
    /**
     * 获取商品详情
     *
     * @param id 商品ID
     * @return 商品详情
     */
    Optional<GoodsResponse> getGoods(Long id);
}
