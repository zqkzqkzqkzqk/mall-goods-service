package com.mall.goods.domain.model.category;

public record CategoryId(Long value) {
    public CategoryId {
        if (value == null || value <= 0) {
            throw new RuntimeException("分类ID必须是正整数");
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }
}