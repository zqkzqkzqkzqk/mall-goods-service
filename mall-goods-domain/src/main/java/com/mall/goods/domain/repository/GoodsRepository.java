package com.mall.goods.domain.repository;

import com.mall.goods.domain.model.goods.Goods;
import com.mall.goods.domain.model.goods.GoodsCommon;
import com.mall.goods.domain.model.goods.GoodsCommonId;
import com.mall.goods.domain.model.goods.GoodsId;
import com.mall.goods.domain.model.goods.StoreId;

import java.util.List;
import java.util.Optional;

/**
 * 商品仓储接口
 */
public interface GoodsRepository {
    
    // GoodsCommon相关方法
    
    /**
     * 保存商品通用信息
     * @param goodsCommon 商品通用信息
     * @return 保存后的商品通用信息
     */
    GoodsCommon saveGoodsCommon(GoodsCommon goodsCommon);
    
    /**
     * 根据ID查找商品通用信息
     * @param goodsCommonId 商品通用信息ID
     * @return 商品通用信息
     */
    Optional<GoodsCommon> findGoodsCommonById(GoodsCommonId goodsCommonId);
    
    /**
     * 根据店铺ID查找商品列表
     * @param storeId 店铺ID
     * @return 商品列表
     */
    List<GoodsCommon> findGoodsCommonByStoreId(StoreId storeId);
    
    /**
     * 根据分类ID查找商品列表
     * @param categoryId 分类ID
     * @return 商品列表
     */
    List<GoodsCommon> findGoodsCommonByCategoryId(Long categoryId);
    
    /**
     * 根据品牌ID查找商品列表
     * @param brandId 品牌ID
     * @return 商品列表
     */
    List<GoodsCommon> findGoodsCommonByBrandId(Long brandId);
    
    /**
     * 根据商品名称查找商品
     * @param goodsName 商品名称
     * @return 商品通用信息
     */
    Optional<GoodsCommon> findGoodsCommonByGoodsName(String goodsName);
    
    /**
     * 根据商品序列号查找商品
     * @param goodsSerial 商品序列号
     * @return 商品通用信息
     */
    Optional<GoodsCommon> findGoodsCommonByGoodsSerial(String goodsSerial);
    
    /**
     * 删除商品通用信息
     * @param goodsCommonId 商品通用信息ID
     */
    void deleteGoodsCommon(GoodsCommonId goodsCommonId);
    
    /**
     * 检查商品名称是否存在
     * @param goodsName 商品名称
     * @param excludeId 排除的商品ID
     * @return 是否存在
     */
    boolean existsGoodsCommonByGoodsName(String goodsName, GoodsCommonId excludeId);
    
    /**
     * 检查商品序列号是否存在
     * @param goodsSerial 商品序列号
     * @param excludeId 排除的商品ID
     * @return 是否存在
     */
    boolean existsGoodsCommonByGoodsSerial(String goodsSerial, GoodsCommonId excludeId);
    
    // Goods相关方法
    
    /**
     * 保存商品SKU
     * @param goods 商品SKU
     * @return 保存后的商品SKU
     */
    Goods saveGoods(Goods goods);
    
    /**
     * 根据ID查找商品SKU
     * @param goodsId 商品SKU ID
     * @return 商品SKU
     */
    Optional<Goods> findGoodsById(GoodsId goodsId);
    
    /**
     * 根据商品通用信息ID查找所有SKU
     * @param goodsCommonId 商品通用信息ID
     * @return 商品SKU列表
     */
    List<Goods> findGoodsByGoodsCommonId(GoodsCommonId goodsCommonId);
    
    /**
     * 根据商品通用信息ID删除所有SKU
     * @param goodsCommonId 商品通用信息ID
     */
    void deleteGoodsByGoodsCommonId(GoodsCommonId goodsCommonId);
    
    /**
     * 删除商品SKU
     * @param goodsId 商品SKU ID
     */
    void deleteGoods(GoodsId goodsId);
    
    /**
     * 批量保存商品SKU
     * @param goodsList 商品SKU列表
     * @return 保存后的商品SKU列表
     */
    List<Goods> saveAllGoods(List<Goods> goodsList);
} 