package com.mall.goods.application.port.in;

public interface BrandDeleteUseCase {
    /**
     * 删除品牌
     *
     * @param id 品牌ID
     */
    void deleteBrand(Long id);
}
