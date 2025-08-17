package com.mall.goods.domain.event;

import com.mall.goods.domain.model.unit.UnitId;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UnitCreatedEvent extends DomainEvent {
    private final UnitId unitId;
    private final String unitName;
    private final LocalDateTime createdAt;

    public UnitCreatedEvent(UnitId unitId, String unitName) {
        this.unitId = unitId;
        this.unitName = unitName;
        this.createdAt = LocalDateTime.now();
    }
} 