package com.mall.goods.application.service;

import com.mall.goods.application.dto.BrandResponse;
import com.mall.goods.application.port.in.BrandGetByFirstLetterUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandGetByFirstLetterService implements BrandGetByFirstLetterUseCase {
    @Override
    public List<BrandResponse> getBrandsByFirstLetter(String firstLetter) {
        return List.of();
    }
}
