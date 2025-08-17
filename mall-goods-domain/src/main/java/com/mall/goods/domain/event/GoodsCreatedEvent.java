package com.mall.goods.domain.event;

import com.mall.goods.domain.model.brand.BrandId;
import com.mall.goods.domain.model.category.CategoryId;
import com.mall.goods.domain.model.goods.GoodsCommon;
import com.mall.goods.domain.model.goods.GoodsCommonId;
import com.mall.goods.domain.model.goods.GoodsName;
import com.mall.goods.domain.model.goods.StoreId;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class GoodsCreatedEvent extends DomainEvent {
    GoodsCommonId commonId;
    GoodsName goodsName;
    BrandId brandId;
    CategoryId categoryId;
    StoreId storeId;

    public GoodsCreatedEvent(GoodsCommon goodsCommon) {
        this.commonId = goodsCommon.getCommonId();
        this.goodsName = goodsCommon.getGoodsName();
        this.brandId = goodsCommon.getBrandId();
        this.categoryId = goodsCommon.getCategoryId();
        this.storeId = goodsCommon.getStoreId();
    }
}