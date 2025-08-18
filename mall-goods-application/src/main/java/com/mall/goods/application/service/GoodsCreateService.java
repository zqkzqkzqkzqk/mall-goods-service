package com.mall.goods.application.service;

import com.mall.goods.application.port.in.GoodsCreateUseCase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品创建服务用实现用例
 * @author zhangqiankai
 */
@Service
public class GoodsCreateService implements GoodsCreateUseCase {
    @Override
    public Long createGoods(String name, Long categoryId, Long brandId, BigDecimal price, Integer stock, Long unitId, String description, List<String> images, List<Long> specs) {
        return 0L;
    }
}
