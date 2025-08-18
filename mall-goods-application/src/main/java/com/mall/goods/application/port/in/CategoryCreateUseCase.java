package com.mall.goods.application.port.in;

/**
 * 分类创建服务用例接口
 */
public interface CategoryCreateUseCase {
    /**
     * 创建分类
     *
     * @param name 分类名称
     * @param parentId 父分类ID
     * @param level 分类层级
     * @param isShow 是否显示
     * @param sort 排序
     * @param icon 图标
     * @param description 分类描述
     * @return 分类ID
     */
    Long createCategory(String name, Long parentId, Integer level, Boolean isShow, Integer sort, String icon, String description);
}
