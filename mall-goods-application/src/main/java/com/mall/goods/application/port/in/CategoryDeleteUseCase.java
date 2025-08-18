package com.mall.goods.application.port.in;

/**
 * 分类删除服务用例接口
 * @author zhangqiankai
 */
public interface CategoryDeleteUseCase {
    /**
     * 删除分类
     *
     * @param id 分类ID
     */
    void deleteCategory(Long id);
}
