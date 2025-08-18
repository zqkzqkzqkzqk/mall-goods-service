package com.mall.goods.application.port.in;

/**
 * 品牌删除服务用例接口
 * @author zhangqiankai
 */
public interface BrandDeleteUseCase {
    /**
     * 删除品牌
     *
     * @param id 品牌ID
     */
    void deleteBrand(Long id);
}
