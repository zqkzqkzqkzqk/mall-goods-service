package com.mall.goods.domain.model.goods;

public record GoodsId(Long value) {
    public GoodsId {
        if (value == null || value <= 0) {
            throw new RuntimeException("商品SKU ID必须是正整数");
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }
}