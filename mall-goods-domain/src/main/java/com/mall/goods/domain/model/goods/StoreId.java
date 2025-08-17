package com.mall.goods.domain.model.goods;

public record StoreId(Long value) {
    public StoreId {
        if (value == null || value <= 0) {
            throw new RuntimeException("店铺ID必须是正整数");
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }
}