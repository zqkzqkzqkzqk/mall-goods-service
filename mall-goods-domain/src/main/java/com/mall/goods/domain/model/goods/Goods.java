package com.mall.goods.domain.model.goods;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 具体商品SKU聚合根
 * 对应数据库中的goods表
 */
@Getter
public class Goods {

    /**
     * 创建新商品SKU
     */
    public Goods(GoodsId goodsId, GoodsCommonId commonId, String goodsSpecs, 
                String goodsFullSpecs, BigDecimal goodsPrice0, Integer goodsStorage) {
        if (goodsId == null) throw new RuntimeException("商品SKU ID不能为空");
        if (commonId == null) throw new RuntimeException("商品ID不能为空");
        if (goodsPrice0 == null) throw new RuntimeException("商品价格不能为空");
        if (goodsStorage == null) throw new RuntimeException("商品库存不能为空");
        
        this.goodsId = goodsId;
        this.commonId = commonId;
        this.goodsSpecs = goodsSpecs;
        this.goodsFullSpecs = goodsFullSpecs;
        this.goodsPrice0 = goodsPrice0;
        this.webPrice0 = goodsPrice0;
        this.appPrice0 = goodsPrice0;
        this.wechatPrice0 = goodsPrice0;
        this.goodsStorage = goodsStorage;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
        this.isDeleted = false;
    }
    
    /**
     * 从持久化恢复商品SKU对象
     */
    public Goods(GoodsId goodsId, GoodsCommonId commonId, String goodsSpecs, 
                String goodsFullSpecs, BigDecimal goodsPrice0, BigDecimal webPrice0, 
                BigDecimal appPrice0, BigDecimal wechatPrice0, Integer goodsStorage, 
                LocalDateTime createdAt, LocalDateTime updatedAt, Boolean isDeleted) {
        this.goodsId = goodsId;
        this.commonId = commonId;
        this.goodsSpecs = goodsSpecs;
        this.goodsFullSpecs = goodsFullSpecs;
        this.goodsPrice0 = goodsPrice0;
        this.webPrice0 = webPrice0;
        this.appPrice0 = appPrice0;
        this.wechatPrice0 = wechatPrice0;
        this.goodsStorage = goodsStorage;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDeleted = isDeleted;
    }

    private final GoodsId goodsId;
    private final GoodsCommonId commonId;
    private String goodsSpecs;
    private String goodsFullSpecs;
    private BigDecimal goodsPrice0;
    private BigDecimal webPrice0;
    private BigDecimal appPrice0;
    private BigDecimal wechatPrice0;
    private Integer goodsStorage;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDeleted;
    
    /**
     * 更新商品SKU价格
     */
    public void updatePrice(BigDecimal price) {
        this.goodsPrice0 = price;
        this.webPrice0 = price;
        this.appPrice0 = price;
        this.wechatPrice0 = price;
        this.updatedAt = LocalDateTime.now();
    }
    
    /**
     * 更新商品SKU库存
     */
    public void updateStorage(Integer storage) {
        this.goodsStorage = storage;
        this.updatedAt = LocalDateTime.now();
    }
    
    /**
     * 减少商品SKU库存
     */
    public boolean decreaseStorage(Integer quantity) {
        if (this.goodsStorage >= quantity) {
            this.goodsStorage -= quantity;
            this.updatedAt = LocalDateTime.now();
            return true;
        }
        return false;
    }
    
    /**
     * 增加商品SKU库存
     */
    public void increaseStorage(Integer quantity) {
        this.goodsStorage += quantity;
        this.updatedAt = LocalDateTime.now();
    }
    
    /**
     * 逻辑删除商品SKU
     */
    public void delete() {
        this.isDeleted = true;
        this.updatedAt = LocalDateTime.now();
    }
    
    /**
     * 恢复已删除商品SKU
     */
    public void restore() {
        this.isDeleted = false;
        this.updatedAt = LocalDateTime.now();
    }
}