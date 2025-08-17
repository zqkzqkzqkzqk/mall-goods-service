package com.mall.goods.domain.model.spec;

import lombok.Value;

@Value
public class SpecId {
    Long value;
    
    public SpecId(Long value) {
        this.value = value;
    }
    
    public Long getValue() {
        return value;
    }
}