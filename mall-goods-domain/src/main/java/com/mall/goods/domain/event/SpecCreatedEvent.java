package com.mall.goods.domain.event;

import com.mall.goods.domain.model.spec.SpecId;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SpecCreatedEvent extends DomainEvent {
    private final SpecId specId;
    private final String specName;
    private final LocalDateTime createdAt;

    public SpecCreatedEvent(SpecId specId, String specName) {
        this.specId = specId;
        this.specName = specName;
        this.createdAt = LocalDateTime.now();
    }
} 