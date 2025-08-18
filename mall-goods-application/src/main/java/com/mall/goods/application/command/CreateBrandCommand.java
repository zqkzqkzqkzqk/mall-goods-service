package com.mall.goods.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 创建品牌命令
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBrandCommand {
    /**
     * 品牌名称
     */
    @NotBlank(message = "品牌名称不能为空")
    private String name;

    /**
     * 品牌描述
     */
    private String description;

    /**
     * 品牌logo
     */
    private String logo;

    /**
     * 品牌首字母
     */
    private String firstLetter;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否显示
     */
    @NotNull(message = "是否显示不能为空")
    private Boolean isShow;
}
