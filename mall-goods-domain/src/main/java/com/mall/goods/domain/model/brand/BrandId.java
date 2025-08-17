package com.mall.goods.domain.model.brand;

public record BrandId(Long value) {
    public BrandId {
        if (value == null || value <= 0) {
            throw new RuntimeException("品牌ID必须是正整数");
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }
}