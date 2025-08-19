package com.mall.goods.domain.model.brand;

import com.mall.goods.domain.event.BrandCreatedEvent;
import com.mall.goods.domain.event.DomainEvent;
import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Brand {

    public Brand(BrandId brandId, String brandName, String brandEnglish, String brandInitial, 
                String brandImage, Integer brandSort, Integer isRecommend, Integer showType, Long storeId) {
        this(brandId, brandName, brandEnglish, brandInitial, brandImage, brandSort, isRecommend, showType, storeId, null, 0L);
    }

    public Brand(BrandId brandId, String brandName, String brandEnglish, String brandInitial, 
                String brandImage, Integer brandSort, Integer isRecommend, Integer showType, 
                Long storeId, Integer applyState, Long createdBy) {
        if (brandId == null) {
            throw new IllegalArgumentException("品牌ID不能为空");
        }
        if (brandName == null || brandName.trim().isEmpty()) {
            throw new IllegalArgumentException("品牌名称不能为空");
        }
        if (brandName.length() > 30) {
            throw new IllegalArgumentException("品牌名称长度不能超过30个字符");
        }
        if (brandEnglish != null && brandEnglish.length() > 30) {
            throw new IllegalArgumentException("品牌英文名长度不能超过30个字符");
        }

        this.brandId = brandId;
        this.brandName = brandName;
        this.brandEnglish = brandEnglish;
        this.brandInitial = brandInitial;
        this.brandImage = brandImage;
        this.brandSort = brandSort != null ? brandSort : 0;
        this.isRecommend = isRecommend != null ? isRecommend : 0;
        this.showType = showType != null ? showType : 0;
        this.storeId = storeId;
        this.applyState = applyState != null ? applyState : 0;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
        this.createdBy = createdBy;
        this.updatedBy = createdBy;
        this.isDeleted = false;

        registerEvent(new BrandCreatedEvent(this.brandId, this.brandName));
    }

    /**
     * 用于从持久化层恢复Brand对象的构造函数
     */
    public Brand(BrandId brandId, String brandName, String brandEnglish, String brandInitial,
                String brandImage, Integer brandSort, Integer isRecommend, Integer showType,
                Long storeId, Integer applyState, LocalDateTime createdAt, LocalDateTime updatedAt,
                Long createdBy, Long updatedBy, boolean isDeleted) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandEnglish = brandEnglish;
        this.brandInitial = brandInitial;
        this.brandImage = brandImage;
        this.brandSort = brandSort;
        this.isRecommend = isRecommend;
        this.showType = showType;
        this.storeId = storeId;
        this.applyState = applyState;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.isDeleted = isDeleted;
    }

    private final BrandId brandId;
    private String brandName;
    private String brandEnglish;
    private String brandInitial;
    private String brandImage;
    private Integer brandSort;
    private Integer isRecommend;
    private Integer showType;
    private final Long storeId;
    private Integer applyState;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private final Long createdBy;
    private Long updatedBy;
    private boolean isDeleted;

    @Getter(value = AccessLevel.NONE)
    private final List<DomainEvent> events = new ArrayList<>();

    /**
     * 更新品牌名称
     * @param newBrandName 新的品牌名称
     */
    public void updateBrandName(String newBrandName) {
        if (newBrandName == null || newBrandName.trim().isEmpty()) {
            throw new IllegalArgumentException("品牌名称不能为空");
        }
        if (newBrandName.length() > 30) {
            throw new IllegalArgumentException("品牌名称长度不能超过30个字符");
        }
        this.brandName = newBrandName;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 更新品牌英文名
     * @param newBrandEnglish 新的品牌英文名
     */
    public void updateBrandEnglish(String newBrandEnglish) {
        if (newBrandEnglish != null && newBrandEnglish.length() > 30) {
            throw new IllegalArgumentException("品牌英文名长度不能超过30个字符");
        }
        this.brandEnglish = newBrandEnglish;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 更新品牌图片
     * @param newBrandImage 新的品牌图片
     */
    public void updateBrandImage(String newBrandImage) {
        this.brandImage = newBrandImage;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 更新品牌排序
     * @param newBrandSort 新的排序值
     */
    public void updateBrandSort(Integer newBrandSort) {
        this.brandSort = newBrandSort != null ? newBrandSort : 0;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 设置推荐状态
     * @param isRecommend 是否推荐
     */
    public void setRecommend(boolean isRecommend) {
        this.isRecommend = isRecommend ? 1 : 0;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 更新申请状态
     * @param newApplyState 新的申请状态
     */
    public void updateApplyState(Integer newApplyState) {
        this.applyState = newApplyState;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 检查是否为推荐品牌
     * @return 是否为推荐品牌
     */
    public boolean isRecommendBrand() {
        return isRecommend != null && isRecommend == 1;
    }

    /**
     * 检查申请是否通过
     * @return 申请是否通过
     */
    public boolean isApproved() {
        return applyState != null && applyState == 1;
    }

    /**
     * 检查是否可以删除
     * @return 是否可以删除
     */
    public boolean canBeDeleted() {
        return !isDeleted;
    }

    /**
     * 标记为删除
     */
    public void markAsDeleted() {
        this.isDeleted = true;
        this.updatedAt = LocalDateTime.now();
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

    public boolean isDeleted() {
        return isDeleted;
    }
} 