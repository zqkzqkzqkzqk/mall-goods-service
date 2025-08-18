package com.mall.goods.application.port.in;

import com.mall.goods.application.command.CreateBrandCommand;

/**
 * 品牌创建服务用例接口
 * @author zhangqiankai
 */
public interface BrandCreateUseCase {
    /**
     * 创建品牌
     *
     * @param command 创建品牌命令
     * @return 品牌ID
     */
    Long createBrand(CreateBrandCommand command);
}
