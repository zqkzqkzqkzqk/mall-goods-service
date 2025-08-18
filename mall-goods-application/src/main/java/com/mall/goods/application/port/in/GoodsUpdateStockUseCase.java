package com.mall.goods.application.port.in;

/**
 * 商品库存更新服务用例接口
 */
public interface GoodsUpdateStockUseCase {
    /**
     * 更新商品库存
     *
     * @param id 商品ID
     * @param stock 库存
     */
    void updateGoodsStock(Long id, Integer stock);
}
