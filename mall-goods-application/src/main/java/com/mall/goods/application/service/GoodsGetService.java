package com.mall.goods.application.service;

import com.mall.goods.application.dto.GoodsResponse;
import com.mall.goods.application.port.in.GoodsGetUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 商品详情获取服务实现用例
 * @author zhangqiankai
 */
@Service
public class GoodsGetService implements GoodsGetUseCase {
    @Override
    public Optional<GoodsResponse> getGoods(Long id) {
        return Optional.empty();
    }
}
