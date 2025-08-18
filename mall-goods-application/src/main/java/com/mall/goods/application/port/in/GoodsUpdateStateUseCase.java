package com.mall.goods.application.port.in;

/**
 * 商品状态更新服务用例接口
 */
public interface GoodsUpdateStateUseCase {
    /**
     * 更新商品状态
     *
     * @param id 商品ID
     * @param state 状态
     */
    void updateGoodsState(Long id, Integer state);
}
