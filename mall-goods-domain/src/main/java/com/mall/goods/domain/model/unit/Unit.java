package com.mall.goods.domain.model.unit;

import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Unit {

    public Unit(UnitId unitId, String name, Integer sort) {
        this(unitId, name, sort, 0L);
    }

    public Unit(UnitId unitId, String name, Integer sort, Long createdBy) {
        if (unitId == null) {
            throw new IllegalArgumentException("单位ID不能为空");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("单位名称不能为空");
        }
        if (name.length() > 20) {
            throw new IllegalArgumentException("单位名称长度不能超过20个字符");
        }

        this.unitId = unitId;
        this.name = name;
        this.sort = sort != null ? sort : 0;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
        this.createdBy = createdBy;
        this.updatedBy = createdBy;
        this.isDeleted = false;
    }

    /**
     * 用于从持久化层恢复Unit对象的构造函数
     */
    public Unit(UnitId unitId, String name, Integer sort, LocalDateTime createdAt, 
                LocalDateTime updatedAt, Long createdBy, Long updatedBy, boolean isDeleted) {
        this.unitId = unitId;
        this.name = name;
        this.sort = sort;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.isDeleted = isDeleted;
    }

    private final UnitId unitId;
    private String name;
    private Integer sort;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private final Long createdBy;
    private Long updatedBy;
    private boolean isDeleted;

    /**
     * 更新单位名称
     * @param newName 新的单位名称
     */
    public void updateName(String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("单位名称不能为空");
        }
        if (newName.length() > 20) {
            throw new IllegalArgumentException("单位名称长度不能超过20个字符");
        }
        this.name = newName;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 更新排序
     * @param newSort 新的排序值
     */
    public void updateSort(Integer newSort) {
        this.sort = newSort != null ? newSort : 0;
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