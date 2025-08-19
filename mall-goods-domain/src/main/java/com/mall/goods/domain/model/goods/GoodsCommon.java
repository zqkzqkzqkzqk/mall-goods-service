package com.mall.goods.domain.model.goods;

import com.mall.goods.domain.event.DomainEvent;
import com.mall.goods.domain.event.GoodsCreatedEvent;
import com.mall.goods.domain.model.brand.BrandId;
import com.mall.goods.domain.model.category.CategoryId;
import lombok.AccessLevel;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 商品聚合根
 * 对应数据库中的goods_common表
 */
@Getter
public class GoodsCommon {

    /**
     * 创建新商品
     */
    public GoodsCommon(GoodsCommonId commonId, GoodsName goodsName, BrandId brandId, 
                      CategoryId categoryId, StoreId storeId, BigDecimal price, 
                      String imageName, String goodsSpecNames) {
        if (commonId == null) {
            throw new RuntimeException("商品ID不能为空");
        }
        if (goodsName == null) {
            throw new RuntimeException("商品名称不能为空");
        }
        if (categoryId == null) {
            throw new RuntimeException("商品分类不能为空");
        }
        if (storeId == null) {
            throw new RuntimeException("店铺ID不能为空");
        }
        if (price == null) {
            throw new RuntimeException("商品价格不能为空");
        }
        
        this.commonId = commonId;
        this.goodsName = goodsName;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.storeId = storeId;
        this.webPrice0 = price;
        this.appPrice0 = price;
        this.wechatPrice0 = price;
        this.imageName = imageName;
        this.goodsSpecNames = goodsSpecNames;
        this.goodsState = 0; // 默认状态
        this.goodsVerify = 0; // 默认未审核
        this.goodsClick = 0;
        this.goodsFavorite = 0;
        this.goodsSaleNum = 0;
        this.evaluateNum = 0;
        this.createTime = LocalDateTime.now();
        this.updateTime = this.createTime;
        this.createdAt = this.createTime;
        this.updatedAt = this.createTime;
        this.isDeleted = false;
        
        registerEvent(new GoodsCreatedEvent(this));
    }
    
    /**
     * 从持久化恢复商品对象
     */
    public GoodsCommon(GoodsCommonId commonId, GoodsName goodsName, BrandId brandId, 
                      CategoryId categoryId, CategoryId categoryId1, CategoryId categoryId2, 
                      CategoryId categoryId3, StoreId storeId, BigDecimal webPrice0, 
                      BigDecimal appPrice0, BigDecimal wechatPrice0, String imageName, 
                      String goodsSpecNames, Integer goodsState, Integer goodsVerify, 
                      Integer goodsClick, Integer goodsFavorite, Integer goodsSaleNum, 
                      Integer evaluateNum, LocalDateTime createTime, LocalDateTime updateTime,
                      LocalDateTime createdAt, LocalDateTime updatedAt, Boolean isDeleted) {
        this.commonId = commonId;
        this.goodsName = goodsName;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.categoryId1 = categoryId1;
        this.categoryId2 = categoryId2;
        this.categoryId3 = categoryId3;
        this.storeId = storeId;
        this.webPrice0 = webPrice0;
        this.appPrice0 = appPrice0;
        this.wechatPrice0 = wechatPrice0;
        this.imageName = imageName;
        this.goodsSpecNames = goodsSpecNames;
        this.goodsState = goodsState;
        this.goodsVerify = goodsVerify;
        this.goodsClick = goodsClick;
        this.goodsFavorite = goodsFavorite;
        this.goodsSaleNum = goodsSaleNum;
        this.evaluateNum = evaluateNum;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDeleted = isDeleted;
    }

    private final GoodsCommonId commonId;
    private GoodsName goodsName;
    private BrandId brandId;
    private CategoryId categoryId;
    private CategoryId categoryId1;
    private CategoryId categoryId2;
    private CategoryId categoryId3;
    private final StoreId storeId;
    private BigDecimal webPrice0;
    private BigDecimal appPrice0;
    private BigDecimal wechatPrice0;
    private String imageName;
    private String goodsSpecNames;
    private Integer goodsState;
    private Integer goodsVerify;
    private Integer goodsClick;
    private Integer goodsFavorite;
    private Integer goodsSaleNum;
    private Integer evaluateNum;
    private final LocalDateTime createTime;
    private LocalDateTime updateTime;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDeleted;
    
    @Getter(value = AccessLevel.NONE)
    private final List<DomainEvent> events = new ArrayList<>();
    
    /**
     * 更新商品基本信息
     */
    public void updateBasicInfo(GoodsName goodsName, BrandId brandId, CategoryId categoryId, 
                               BigDecimal price, String imageName) {
        if (goodsName != null) {
            this.goodsName = goodsName;
        }
        if (brandId != null) {
            this.brandId = brandId;
        }
        if (categoryId != null) {
            this.categoryId = categoryId;
        }
        if (price != null) {
            this.webPrice0 = price;
            this.appPrice0 = price;
            this.wechatPrice0 = price;
        }
        if (imageName != null && !imageName.isEmpty()) {
            this.imageName = imageName;
        }
        this.updateTime = LocalDateTime.now();
        this.updatedAt = this.updateTime;
    }
    
    /**
     * 更新商品状态
     */
    public void updateState(Integer goodsState) {
        this.goodsState = goodsState;
        this.updateTime = LocalDateTime.now();
        this.updatedAt = this.updateTime;
    }
    
    /**
     * 审核商品
     */
    public void verify(Integer verifyResult, String verifyRemark) {
        this.goodsVerify = verifyResult;
        this.updateTime = LocalDateTime.now();
        this.updatedAt = this.updateTime;
    }
    
    /**
     * 增加商品点击量
     */
    public void increaseClick() {
        this.goodsClick++;
        this.updateTime = LocalDateTime.now();
        this.updatedAt = this.updateTime;
    }
    
    /**
     * 增加商品收藏数
     */
    public void increaseFavorite() {
        this.goodsFavorite++;
        this.updateTime = LocalDateTime.now();
        this.updatedAt = this.updateTime;
    }
    
    /**
     * 减少商品收藏数
     */
    public void decreaseFavorite() {
        if (this.goodsFavorite > 0) {
            this.goodsFavorite--;
            this.updateTime = LocalDateTime.now();
            this.updatedAt = this.updateTime;
        }
    }
    
    /**
     * 增加商品销量
     */
    public void increaseSaleNum(Integer num) {
        this.goodsSaleNum += num;
        this.updateTime = LocalDateTime.now();
        this.updatedAt = this.updateTime;
    }
    
    /**
     * 增加评价数量
     */
    public void increaseEvaluateNum() {
        this.evaluateNum++;
        this.updateTime = LocalDateTime.now();
        this.updatedAt = this.updateTime;
    }
    
    /**
     * 逻辑删除商品
     */
    public void delete() {
        this.isDeleted = true;
        this.updateTime = LocalDateTime.now();
        this.updatedAt = this.updateTime;
    }
    
    /**
     * 恢复已删除商品
     */
    public void restore() {
        this.isDeleted = false;
        this.updateTime = LocalDateTime.now();
        this.updatedAt = this.updateTime;
    }
    
    private void registerEvent(DomainEvent event) {
        events.add(event);
    }

    public List<DomainEvent> getEvents() {
        return Collections.unmodifiableList(events);
    }

    public void clearEvents() {
        events.clear();
    }
}