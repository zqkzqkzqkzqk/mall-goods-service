package com.mall.goods.application.service;

import com.mall.goods.application.port.in.GoodsUpdateStockUseCase;
import org.springframework.stereotype.Service;

@Service
public class GoodsUpdateStockService implements GoodsUpdateStockUseCase {
    @Override
    public void updateGoodsStock(Long id, Integer stock) {

    }
}
