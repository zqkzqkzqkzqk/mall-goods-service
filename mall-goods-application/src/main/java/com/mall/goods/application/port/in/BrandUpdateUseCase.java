package com.mall.goods.application.port.in;

import com.mall.goods.application.command.CreateBrandCommand;

/**
 * 品牌更新服务用例接口
 */
public interface BrandUpdateUseCase {
    /**
     * 更新品牌
     *
     * @param id 品牌ID
     * @param command 更新品牌命令
     */
    void updateBrand(Long id, CreateBrandCommand command);
}
