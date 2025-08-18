package com.mall.goods.application.port.in;

import com.mall.goods.application.command.CreateBrandCommand;
import com.mall.goods.application.dto.BrandResponse;

import java.util.List;
import java.util.Optional;

/**
 * 品牌用例接口
 */
public interface BrandUseCase {

    /**
     * 创建品牌
     *
     * @param command 创建品牌命令
     * @return 品牌ID
     */
    Long createBrand(CreateBrandCommand command);

    /**
     * 更新品牌
     *
     * @param id 品牌ID
     * @param command 更新品牌命令
     */
    void updateBrand(Long id, CreateBrandCommand command);

    /**
     * 删除品牌
     *
     * @param id 品牌ID
     */
    void deleteBrand(Long id);

    /**
     * 获取品牌详情
     *
     * @param id 品牌ID
     * @return 品牌详情
     */
    Optional<BrandResponse> getBrand(Long id);

    /**
     * 获取品牌列表
     *
     * @return 品牌列表
     */
    List<BrandResponse> listBrands();

    /**
     * 根据名称搜索品牌
     *
     * @param name 品牌名称
     * @return 品牌列表
     */
    List<BrandResponse> searchBrandsByName(String name);

    /**
     * 根据首字母获取品牌列表
     *
     * @param firstLetter 首字母
     * @return 品牌列表
     */
    List<BrandResponse> getBrandsByFirstLetter(String firstLetter);
}
