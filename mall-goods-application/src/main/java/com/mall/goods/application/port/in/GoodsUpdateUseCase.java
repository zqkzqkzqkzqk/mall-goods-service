package com.mall.goods.application.port.in;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品更新服务用例接口
 */
public interface GoodsUpdateUseCase {
    /**
     * 更新商品
     *
     * @param id 商品ID
     * @param name 商品名称
     * @param categoryId 分类ID
     * @param brandId 品牌ID
     * @param price 价格
     * @param stock 库存
     * @param unitId 单位ID
     * @param description 商品描述
     * @param images 商品图片
     * @param specs 商品规格
     */
    void updateGoods(Long id, String name, Long categoryId, Long brandId, BigDecimal price,
                     Integer stock, Long unitId, String description, List<String> images,
                     List<Long> specs);
}
