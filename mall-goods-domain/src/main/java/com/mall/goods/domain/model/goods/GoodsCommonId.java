package com.mall.goods.domain.model.goods;

public record GoodsCommonId(Long value) {
    public GoodsCommonId {
        if (value == null || value <= 0) {
            throw new RuntimeException("商品ID必须是正整数");
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }
}