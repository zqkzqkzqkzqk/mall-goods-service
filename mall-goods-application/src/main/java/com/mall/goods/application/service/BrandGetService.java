package com.mall.goods.application.service;

import com.mall.goods.application.dto.BrandResponse;
import com.mall.goods.application.port.in.BrandGetUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandGetService implements BrandGetUseCase {
    @Override
    public Optional<BrandResponse> getBrand(Long id) {
        return Optional.empty();
    }
}
