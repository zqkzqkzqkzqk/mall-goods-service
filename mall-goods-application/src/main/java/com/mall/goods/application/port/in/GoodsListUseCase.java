package com.mall.goods.application.port.in;

import com.mall.goods.application.dto.GoodsResponse;

import java.math.BigDecimal;
import java.util.List;

public interface GoodsListUseCase {
    /**
     * 获取商品列表
     *
     * @param categoryId 分类ID
     * @param brandId 品牌ID
     * @param minPrice 最低价格
     * @param maxPrice 最高价格
     * @param keyword 关键词
     * @param page 页码
     * @param size 每页大小
     * @return 商品列表
     */
    List<GoodsResponse> listGoods(Long categoryId, Long brandId, BigDecimal minPrice,
                                  BigDecimal maxPrice, String keyword, Integer page, Integer size);
}
