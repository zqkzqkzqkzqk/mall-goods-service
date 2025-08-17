package com.mall.goods.domain.event;

import com.mall.goods.domain.model.brand.BrandId;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BrandCreatedEvent extends DomainEvent {
    private final BrandId brandId;
    private final String brandName;
    private final LocalDateTime createdAt;

    public BrandCreatedEvent(BrandId brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.createdAt = LocalDateTime.now();
    }
} 