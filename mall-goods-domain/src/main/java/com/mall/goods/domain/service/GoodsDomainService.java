package com.mall.goods.domain.service;

import com.mall.goods.domain.model.goods.GoodsCommon;
import com.mall.goods.domain.model.goods.GoodsCommonId;
import com.mall.goods.domain.model.category.CategoryId;
import com.mall.goods.domain.model.brand.BrandId;

/**
 * 商品领域服务
 * 处理商品相关的业务逻辑
 */
public interface GoodsDomainService {
    
    /**
     * 检查商品名称是否重复
     * @param goodsName 商品名称
     * @param excludeId 排除的商品ID
     * @return 是否重复
     */
    boolean isGoodsNameDuplicate(String goodsName, GoodsCommonId excludeId);
    
    /**
     * 检查商品序列号是否重复
     * @param goodsSerial 商品序列号
     * @param excludeId 排除的商品ID
     * @return 是否重复
     */
    boolean isGoodsSerialDuplicate(String goodsSerial, GoodsCommonId excludeId);
    
    /**
     * 验证分类是否存在且有效
     * @param categoryId 分类ID
     * @return 是否有效
     */
    boolean isCategoryValid(CategoryId categoryId);
    
    /**
     * 验证品牌是否存在且有效
     * @param brandId 品牌ID
     * @return 是否有效
     */
    boolean isBrandValid(BrandId brandId);
    
    /**
     * 计算商品价格
     * @param goodsCommon 商品通用信息
     * @return 计算后的价格信息
     */
    GoodsPriceInfo calculateGoodsPrice(GoodsCommon goodsCommon);
    
    /**
     * 验证商品状态变更
     * @param oldState 原状态
     * @param newState 新状态
     * @return 是否可以变更
     */
    boolean canChangeGoodsState(int oldState, int newState);
    
    /**
     * 商品价格信息
     */
    class GoodsPriceInfo {
        private final double minPrice;
        private final double maxPrice;
        private final double avgPrice;
        
        public GoodsPriceInfo(double minPrice, double maxPrice, double avgPrice) {
            this.minPrice = minPrice;
            this.maxPrice = maxPrice;
            this.avgPrice = avgPrice;
        }
        
        public double getMinPrice() { return minPrice; }
        public double getMaxPrice() { return maxPrice; }
        public double getAvgPrice() { return avgPrice; }
    }
} 