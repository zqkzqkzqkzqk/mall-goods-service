package com.mall.goods.application.service;

import com.mall.goods.application.dto.BrandResponse;
import com.mall.goods.application.port.in.BrandListUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandListService implements BrandListUseCase {
    @Override
    public List<BrandResponse> listBrands() {
        return List.of();
    }
}
