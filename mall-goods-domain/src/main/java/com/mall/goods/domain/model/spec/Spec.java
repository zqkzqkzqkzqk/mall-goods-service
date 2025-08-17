package com.mall.goods.domain.model.spec;

import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Spec {

    public Spec(SpecId specId, String specName, Long storeId) {
        this(specId, specName, storeId, 0L);
    }

    public Spec(SpecId specId, String specName, Long storeId, Long createdBy) {
        if (specId == null) throw new IllegalArgumentException("规格ID不能为空");
        if (specName == null || specName.trim().isEmpty()) {
            throw new IllegalArgumentException("规格名称不能为空");
        }
        if (specName.length() > 12) {
            throw new IllegalArgumentException("规格名称长度不能超过12个字符");
        }

        this.specId = specId;
        this.specName = specName;
        this.storeId = storeId;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
        this.createdBy = createdBy;
        this.updatedBy = createdBy;
        this.isDeleted = false;
    }

    /**
     * 用于从持久化层恢复Spec对象的构造函数
     */
    public Spec(SpecId specId, String specName, Long storeId, LocalDateTime createdAt, 
                LocalDateTime updatedAt, Long createdBy, Long updatedBy, boolean isDeleted) {
        this.specId = specId;
        this.specName = specName;
        this.storeId = storeId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.isDeleted = isDeleted;
    }

    private final SpecId specId;
    private String specName;
    private final Long storeId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private final Long createdBy;
    private Long updatedBy;
    private boolean isDeleted;

    @Getter(value = AccessLevel.NONE)
    private final List<Object> events = new ArrayList<>();

    /**
     * 更新规格名称
     * @param newSpecName 新的规格名称
     */
    public void updateSpecName(String newSpecName) {
        if (newSpecName == null || newSpecName.trim().isEmpty()) {
            throw new IllegalArgumentException("规格名称不能为空");
        }
        if (newSpecName.length() > 12) {
            throw new IllegalArgumentException("规格名称长度不能超过12个字符");
        }
        this.specName = newSpecName;
        this.updatedAt = LocalDateTime.now();
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

    public List<Object> getEvents() {
        return Collections.unmodifiableList(events);
    }

    public void clearEvents() {
        events.clear();
    }

    public boolean isDeleted() {
        return isDeleted;
    }
}