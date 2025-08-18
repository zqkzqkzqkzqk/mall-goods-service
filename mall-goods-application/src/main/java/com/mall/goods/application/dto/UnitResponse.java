package com.mall.goods.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 单位响应对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitResponse {
    /**
     * 单位ID
     */
    private Long id;

    /**
     * 单位名称
     */
    private String name;

    /**
     * 单位代码
     */
    private String code;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
