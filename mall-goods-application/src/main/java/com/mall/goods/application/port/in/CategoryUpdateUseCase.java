package com.mall.goods.application.port.in;

/**
 * 分类更新服务用例接口
 */
public interface CategoryUpdateUseCase {
    /**
     * 更新分类
     *
     * @param id 分类ID
     * @param name 分类名称
     * @param parentId 父分类ID
     * @param level 分类层级
     * @param isShow 是否显示
     * @param sort 排序
     * @param icon 图标
     * @param description 分类描述
     */
    void updateCategory(Long id, String name, Long parentId, Integer level, Boolean isShow, Integer sort, String icon, String description);
}
