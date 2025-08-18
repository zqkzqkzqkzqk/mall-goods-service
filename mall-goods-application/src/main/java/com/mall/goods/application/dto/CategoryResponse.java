package com.mall.goods.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 分类响应对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    /**
     * 分类ID
     */
    private Long id;

    /**
     * 父分类ID
     */
    private Long parentId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类层级
     */
    private Integer level;

    /**
     * 是否显示
     */
    private Boolean isShow;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图标
     */
    private String icon;

    /**
     * 分类描述
     */
    private String description;

    /**
     * 子分类列表
     */
    private List<CategoryResponse> children;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
