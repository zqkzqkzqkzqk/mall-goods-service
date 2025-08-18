package com.mall.goods.application.service;

import com.mall.goods.application.dto.GoodsResponse;
import com.mall.goods.application.port.in.GoodsListUseCase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品列表服务实现用例
 * @author zhangqiankai
 */
@Service
public class GoodsListService implements GoodsListUseCase {
    @Override
    public List<GoodsResponse> listGoods(Long categoryId, Long brandId, BigDecimal minPrice, BigDecimal maxPrice, String keyword, Integer page, Integer size) {
        return List.of();
    }
}
