package com.mall.goods.domain.event;

import com.mall.goods.domain.model.goods.GoodsCommonId;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GoodsDeletedEvent extends DomainEvent {
    private final GoodsCommonId goodsCommonId;
    private final LocalDateTime deletedAt;

    public GoodsDeletedEvent(GoodsCommonId goodsCommonId) {
        this.goodsCommonId = goodsCommonId;
        this.deletedAt = LocalDateTime.now();
    }
} 