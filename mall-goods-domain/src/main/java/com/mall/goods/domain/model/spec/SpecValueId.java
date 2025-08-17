package com.mall.goods.domain.model.spec;

import lombok.Value;

@Value
public class SpecValueId {
    Long value;
    
    public SpecValueId(Long value) {
        this.value = value;
    }
    
    public Long getValue() {
        return value;
    }
}