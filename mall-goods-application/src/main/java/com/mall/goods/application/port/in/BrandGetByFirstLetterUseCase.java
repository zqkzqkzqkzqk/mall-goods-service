package com.mall.goods.application.port.in;

import com.mall.goods.application.dto.BrandResponse;

import java.util.List;

/**
 * 根据首字母获取品牌列表服务用例接口
 */
public interface BrandGetByFirstLetterUseCase {
    /**
     * 根据首字母获取品牌列表
     *
     * @param firstLetter 首字母
     * @return 品牌列表
     */
    List<BrandResponse> getBrandsByFirstLetter(String firstLetter);
}
