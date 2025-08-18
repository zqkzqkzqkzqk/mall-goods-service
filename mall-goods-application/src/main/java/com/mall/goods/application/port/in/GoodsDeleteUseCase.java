package com.mall.goods.application.port.in;

/**
 * 商品删除服务用例接口
 * @author zhangqiankai
 */
public interface GoodsDeleteUseCase {
    /**
     * 删除商品
     *
     * @param id 商品ID
     */
    void deleteGoods(Long id);
}
