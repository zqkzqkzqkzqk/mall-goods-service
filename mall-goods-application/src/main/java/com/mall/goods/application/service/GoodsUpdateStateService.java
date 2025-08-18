package com.mall.goods.application.service;

import com.mall.goods.application.port.in.GoodsUpdateStateUseCase;
import org.springframework.stereotype.Service;

/**
 * 商品状态更新服务实现用例
 */
@Service
public class GoodsUpdateStateService implements GoodsUpdateStateUseCase {
    @Override
    public void updateGoodsState(Long id, Integer state) {

    }
}
