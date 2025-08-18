package com.mall.goods.application.service;

import com.mall.goods.application.port.in.GoodsUpdateStateUseCase;
import org.springframework.stereotype.Service;

@Service
public class GoodsUpdateStateService implements GoodsUpdateStateUseCase {
    @Override
    public void updateGoodsState(Long id, Integer state) {

    }
}
