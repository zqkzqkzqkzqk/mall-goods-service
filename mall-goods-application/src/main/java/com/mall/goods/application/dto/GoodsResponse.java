package com.mall.goods.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 商品响应对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsResponse {
    /**
     * 商品ID
     */
    private Long id;

    /**
     * 商品通用ID
     */
    private Long commonId;

    /**
     * 店铺ID
     */
    private Long storeId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品副标题
     */
    private String subtitle;

    /**
     * 商品分类ID
     */
    private Long categoryId;

    /**
     * 商品品牌ID
     */
    private Long brandId;

    /**
     * 商品单位ID
     */
    private Long unitId;

    /**
     * 商品重量，单位：克
     */
    private BigDecimal weight;

    /**
     * 商品价格，单位：元
     */
    private BigDecimal price;

    /**
     * 商品市场价，单位：元
     */
    private BigDecimal marketPrice;

    /**
     * 商品成本价，单位：元
     */
    private BigDecimal costPrice;

    /**
     * 商品库存
     */
    private Integer stock;

    /**
     * 商品预警库存
     */
    private Integer lowStock;

    /**
     * 商品主图
     */
    private String mainPic;

    /**
     * 商品图片，多个图片以逗号分隔
     */
    private String pictures;

    /**
     * 商品详情
     */
    private String detail;

    /**
     * 商品状态：0->下架；1->上架
     */
    private Integer status;

    /**
     * 商品销量
     */
    private Integer sales;

    /**
     * 商品规格，json格式
     */
    private String specifications;

    /**
     * 商品参数，json格式
     */
    private String parameters;

    /**
     * 商品服务保障，json格式
     */
    private String services;

    /**
     * 商品关键字，多个关键字以逗号分隔
     */
    private String keywords;

    /**
     * 商品备注
     */
    private String note;

    /**
     * 商品排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
