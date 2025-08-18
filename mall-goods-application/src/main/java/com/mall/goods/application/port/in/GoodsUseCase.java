package com.mall.goods.application.port.in;

import com.mall.goods.application.dto.GoodsResponse;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * 商品用例接口
 */
public interface GoodsUseCase {

    /**
     * 创建商品
     *
     * @param name 商品名称
     * @param categoryId 分类ID
     * @param brandId 品牌ID
     * @param price 价格
     * @param stock 库存
     * @param unitId 单位ID
     * @param description 商品描述
     * @param images 商品图片
     * @param specs 商品规格
     * @return 商品ID
     */
    Long createGoods(String name, Long categoryId, Long brandId, BigDecimal price,
                    Integer stock, Long unitId, String description, List<String> images,
                    List<Long> specs);

    /**
     * 更新商品
     *
     * @param id 商品ID
     * @param name 商品名称
     * @param categoryId 分类ID
     * @param brandId 品牌ID
     * @param price 价格
     * @param stock 库存
     * @param unitId 单位ID
     * @param description 商品描述
     * @param images 商品图片
     * @param specs 商品规格
     */
    void updateGoods(Long id, String name, Long categoryId, Long brandId, BigDecimal price,
                    Integer stock, Long unitId, String description, List<String> images,
                    List<Long> specs);

    /**
     * 删除商品
     *
     * @param id 商品ID
     */
    void deleteGoods(Long id);

    /**
     * 获取商品详情
     *
     * @param id 商品ID
     * @return 商品详情
     */
    Optional<GoodsResponse> getGoods(Long id);

    /**
     * 获取商品列表
     *
     * @param categoryId 分类ID
     * @param brandId 品牌ID
     * @param minPrice 最低价格
     * @param maxPrice 最高价格
     * @param keyword 关键词
     * @param page 页码
     * @param size 每页大小
     * @return 商品列表
     */
    List<GoodsResponse> listGoods(Long categoryId, Long brandId, BigDecimal minPrice,
                                BigDecimal maxPrice, String keyword, Integer page, Integer size);

    /**
     * 更新商品库存
     *
     * @param id 商品ID
     * @param stock 库存
     */
    void updateGoodsStock(Long id, Integer stock);

    /**
     * 更新商品状态
     *
     * @param id 商品ID
     * @param state 状态
     */
    void updateGoodsState(Long id, Integer state);

    /**
     * 获取推荐商品
     *
     * @param