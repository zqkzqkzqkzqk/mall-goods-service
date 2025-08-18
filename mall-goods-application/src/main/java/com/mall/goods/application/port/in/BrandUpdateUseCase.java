package com.mall.goods.application.port.in;

import com.mall.goods.application.command.CreateBrandCommand;

public interface BrandUpdateUseCase {
    /**
     * 更新品牌
     *
     * @param id 品牌ID
     * @param command 更新品牌命令
     */
    void updateBrand(Long id, CreateBrandCommand command);
}
