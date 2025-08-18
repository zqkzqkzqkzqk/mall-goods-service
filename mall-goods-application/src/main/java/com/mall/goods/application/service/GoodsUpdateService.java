package com.mall.goods.application.service;

import com.mall.goods.application.port.in.GoodsUpdateUseCase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品更新服务实现用例
 * @author zhangqiankai
 */
@Service
public class GoodsUpdateService implements GoodsUpdateUseCase {
    @Override
    public void updateGoods(Long id, String name, Long categoryId, Long brandId, BigDecimal price, Integer stock, Long unitId, String description, List<String> images, List<Long> specs) {
        
    }
}
