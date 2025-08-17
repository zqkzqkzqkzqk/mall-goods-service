package com.mall.goods.domain.event;

import com.mall.goods.domain.model.category.CategoryId;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CategoryCreatedEvent extends DomainEvent {
    private final CategoryId categoryId;
    private final String categoryName;
    private final LocalDateTime createdAt;

    public CategoryCreatedEvent(CategoryId categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.createdAt = LocalDateTime.now();
    }
} 