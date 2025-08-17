package com.mall.goods.domain.event;

import com.mall.goods.domain.model.goods.GoodsCommonId;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GoodsUpdatedEvent extends DomainEvent {
    private final GoodsCommonId goodsCommonId;
    private final LocalDateTime updatedAt;

    public GoodsUpdatedEvent(GoodsCommonId goodsCommonId) {
        this.goodsCommonId = goodsCommonId;
        this.updatedAt = LocalDateTime.now();
    }
} 