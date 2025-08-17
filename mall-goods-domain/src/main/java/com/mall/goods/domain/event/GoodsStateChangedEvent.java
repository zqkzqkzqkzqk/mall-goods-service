package com.mall.goods.domain.event;

import com.mall.goods.domain.model.goods.GoodsCommonId;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GoodsStateChangedEvent extends DomainEvent {
    private final GoodsCommonId goodsCommonId;
    private final int oldState;
    private final int newState;
    private final LocalDateTime changedAt;

    public GoodsStateChangedEvent(GoodsCommonId goodsCommonId, int oldState, int newState) {
        this.goodsCommonId = goodsCommonId;
        this.oldState = oldState;
        this.newState = newState;
        this.changedAt = LocalDateTime.now();
    }
} 