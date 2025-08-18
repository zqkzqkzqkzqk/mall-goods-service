package com.mall.goods.application.port.in;

public interface GoodsUpdateStockUseCase {
    /**
     * 更新商品库存
     *
     * @param id 商品ID
     * @param stock 库存
     */
    void updateGoodsStock(Long id, Integer stock);
}
