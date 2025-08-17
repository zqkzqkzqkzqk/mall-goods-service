package com.mall.goods.domain.model.goods;

public record GoodsName(String value) {
    public GoodsName {
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("商品名称不能为空");
        }
        if (value.length() > 50) {
            throw new RuntimeException("商品名称不能超过50个字符");
        }
    }

    public static GoodsName of(String value) {
        String trimmed = value == null ? null : value.trim();
        return new GoodsName(trimmed);
    }
}