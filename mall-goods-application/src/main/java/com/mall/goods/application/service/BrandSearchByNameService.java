package com.mall.goods.application.service;

import com.mall.goods.application.dto.BrandResponse;
import com.mall.goods.application.port.in.BrandSearchByNameUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 根据名称获取品牌列表服务实现用例
 * @author zhangqiankai
 */
@Service
public class BrandSearchByNameService implements BrandSearchByNameUseCase {
    @Override
    public List<BrandResponse> searchBrandsByName(String name) {
        return List.of();
    }
}
