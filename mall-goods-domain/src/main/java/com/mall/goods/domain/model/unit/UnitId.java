package com.mall.goods.domain.model.unit;

import lombok.Value;

@Value
public class UnitId {
    Long value;
    
    public UnitId(Long value) {
        this.value = value;
    }
    
    public Long getValue() {
        return value;
    }
}