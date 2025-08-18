package com.mall.goods.application.port.in;

public interface GoodsUpdateStateUseCase {
    /**
     * 更新商品状态
     *
     * @param id 商品ID
     * @param state 状态
     */
    void updateGoodsState(Long id, Integer state);
}
