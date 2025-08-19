package com.mall.goods.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * 创建品牌DTO
 * @param brandEnglish
 * @param brandImage
 * @param brandInitial
 * @param brandName
 * @param brandSort
 * @param isRecommend
 * @param showType
 * @param createBy
 * @param updateBy
 */
public record CreateBrandRequest(
        /**
         * 品牌英文名
         */
        @NotBlank(message = "品牌英文名不能为空")
        String brandEnglish,
        /**
         * 品牌图片
         */
        @NotBlank(message = "品牌图片不能为空")
        String brandImage,
        /**
         * 品牌首字母
         */
        @NotBlank(message = "品牌首字母不能为空")
        String brandInitial,
        /**
         * 品牌中文名
         */
        @NotBlank(message = "品牌中文名不能为空")
        String brandName,
        /**
         * 品牌排序
         */
        @NotBlank(message = "品牌排序不能为空")
        String brandSort,
        /**
         * 是否推荐
         */
        @NotBlank(message = "是否推荐不能为空")
        String isRecommend,
        /**
         * 是否显示
         */
        @NotBlank(message = "是否显示不能为空")
        String showType,
        /**
         * 创建人
         */
        @NotBlank(message = "创建人不能为空")
        String createBy
)
{}
