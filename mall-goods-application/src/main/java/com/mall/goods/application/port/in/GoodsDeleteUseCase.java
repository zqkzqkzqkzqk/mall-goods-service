package com.mall.goods.application.port.in;

public interface GoodsDeleteUseCase {
    /**
     * 删除商品
     *
     * @param id 商品ID
     */
    void deleteGoods(Long id);
}
