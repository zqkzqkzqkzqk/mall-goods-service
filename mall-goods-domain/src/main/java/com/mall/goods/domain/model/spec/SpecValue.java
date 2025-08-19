package com.mall.goods.domain.model.spec;

import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SpecValue {

    public SpecValue(SpecValueId specValueId, SpecId specId, String specValueName) {
        this(specValueId, specId, specValueName, 0L);
    }

    public SpecValue(SpecValueId specValueId, SpecId specId, String specValueName, Long createdBy) {
        if (specValueId == null) {
            throw new IllegalArgumentException("规格值ID不能为空");
        }
        if (specId == null) {
            throw new IllegalArgumentException("规格ID不能为空");
        }
        if (specValueName == null || specValueName.trim().isEmpty()) {
            throw new IllegalArgumentException("规格值名称不能为空");
        }
        if (specValueName.length() > 255) {
            throw new IllegalArgumentException("规格值名称长度不能超过255个字符");
        }

        this.specValueId = specValueId;
        this.specId = specId;
        this.specValueName = specValueName;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
        this.createdBy = createdBy;
        this.updatedBy = createdBy;
        this.isDeleted = false;
    }

    /**
     * 用于从持久化层恢复SpecValue对象的构造函数
     */
    public SpecValue(SpecValueId specValueId, SpecId specId, String specValueName, 
                    LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, boolean isDeleted) {
        this.specValueId = specValueId;
        this.specId = specId;
        this.specValueName = specValueName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.isDeleted = isDeleted;
    }

    private final SpecValueId specValueId;
    private final SpecId specId;
    private String specValueName;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private final Long createdBy;
    private Long updatedBy;
    private boolean isDeleted;

    /**
     * 更新规格值名称
     * @param newSpecValueName 新的规格值名称
     */
    public void updateSpecValueName(String newSpecValueName) {
        if (newSpecValueName == null || newSpecValueName.trim().isEmpty()) {
            throw new IllegalArgumentException("规格值名称不能为空");
        }
        if (newSpecValueName.length() > 255) {
            throw new IllegalArgumentException("规格值名称长度不能超过255个字符");
        }
        this.specValueName = newSpecValueName;
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

    public boolean isDeleted() {
        return isDeleted;
    }
}