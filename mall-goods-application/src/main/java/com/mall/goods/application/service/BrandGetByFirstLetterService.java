package com.mall.goods.application.service;

import com.mall.goods.application.dto.BrandResponse;
import com.mall.goods.application.port.in.BrandGetByFirstLetterUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 根据首字母获取品牌列表服务实现用例
 * @author zhangqiankai
 *
 */
@Service
public class BrandGetByFirstLetterService implements BrandGetByFirstLetterUseCase {
    @Override
    public List<BrandResponse> getBrandsByFirstLetter(String firstLetter) {
        return List.of();
    }
}
