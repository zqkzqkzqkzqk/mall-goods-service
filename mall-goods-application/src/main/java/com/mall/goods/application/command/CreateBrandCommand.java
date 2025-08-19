package com.mall.goods.application.command;

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
 */
public record CreateBrandCommand(
        /**
         * 品牌英文名
         */
        String brandEnglish,
        /**
         * 品牌图片
         */
        String brandImage,
        /**
         * 品牌首字母
         */
        String brandInitial,
        /**
         * 品牌中文名
         */
        String brandName,
        /**
         * 品牌排序
         */
        String brandSort,
        /**
         * 是否推荐
         */
        String isRecommend,
        /**
         * 是否显示
         */
        String showType,
        /**
         * 创建人
         */
        String createBy
)
{}
