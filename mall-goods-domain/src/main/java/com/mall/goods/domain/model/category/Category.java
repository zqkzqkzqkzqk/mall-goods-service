package com.mall.goods.domain.model.category;

import com.mall.goods.common.exception.BusinessException;
import com.mall.goods.domain.event.CategoryCreatedEvent;
import com.mall.goods.domain.event.DomainEvent;
import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Category {

    public Category(CategoryId categoryId, String categoryName, Integer categorySort, CategoryId parentId) {
        this(categoryId, categoryName, categorySort, parentId, null, null, 0L);
    }

    public Category(CategoryId categoryId, String categoryName, Integer categorySort, CategoryId parentId, 
                   String appImage, Integer deep, Long createdBy) {
        if (categoryId == null) throw new BusinessException("分类ID不能为空");
        if (categoryName == null || categoryName.trim().isEmpty()) {
            throw new BusinessException("分类名称不能为空");
        }
        if (categoryName.length() > 255) {
            throw new BusinessException("分类名称长度不能超过255个字符");
        }

        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categorySort = categorySort != null ? categorySort : 0;
        this.parentId = parentId;
        this.appImage = appImage;
        this.deep = deep != null ? deep : calculateDepth(parentId);
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
        this.createdBy = createdBy;
        this.updatedBy = createdBy;
        this.isDeleted = false;

        registerEvent(new CategoryCreatedEvent(this.categoryId, this.categoryName));
    }

    /**
     * 用于从持久化层恢复Category对象的构造函数
     */
    public Category(CategoryId categoryId, String categoryName, Integer categorySort, CategoryId parentId,
                   String appImage, Integer deep, LocalDateTime createdAt, LocalDateTime updatedAt, 
                   Long createdBy, Long updatedBy, boolean isDeleted) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categorySort = categorySort;
        this.parentId = parentId;
        this.appImage = appImage;
        this.deep = deep;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.isDeleted = isDeleted;
    }

    private final CategoryId categoryId;
    private String categoryName;
    private Integer categorySort;
    private final CategoryId parentId;
    private String appImage;
    private final Integer deep;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private final Long createdBy;
    private Long updatedBy;
    private boolean isDeleted;

    @Getter(value = AccessLevel.NONE)
    private final List<DomainEvent> events = new ArrayList<>();

    /**
     * 更新分类名称
     * @param newCategoryName 新的分类名称
     */
    public void updateCategoryName(String newCategoryName) {
        if (newCategoryName == null || newCategoryName.trim().isEmpty()) {
            throw new BusinessException("分类名称不能为空");
        }
        if (newCategoryName.length() > 255) {
            throw new BusinessException("分类名称长度不能超过255个字符");
        }
        this.categoryName = newCategoryName;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 更新分类排序
     * @param newCategorySort 新的排序值
     */
    public void updateCategorySort(Integer newCategorySort) {
        this.categorySort = newCategorySort != null ? newCategorySort : 0;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 更新应用图片
     * @param newAppImage 新的应用图片
     */
    public void updateAppImage(String newAppImage) {
        this.appImage = newAppImage;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 检查是否为顶级分类
     * @return 是否为顶级分类
     */
    public boolean isTopLevel() {
        return parentId == null;
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

    /**
     * 计算分类深度
     * @param parentId 父分类ID
     * @return 深度值
     */
    private int calculateDepth(CategoryId parentId) {
        return parentId == null ? 1 : 2; // 简化处理，实际应该递归计算
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