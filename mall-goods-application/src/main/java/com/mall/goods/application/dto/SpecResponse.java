package com.mall.goods.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 规格响应对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecResponse {
    /**
     * 规格ID
     */
    private Long id;

    /**
     * 规格名称
     */
    private String name;

    /**
     * 规格值列表
     */
    private List<SpecValueResponse> values;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 规格值响应对象
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SpecValueResponse {
        /**
         * 规格值ID
         */
        private Long id;

        /**
         * 规格ID
         */
        private Long specId;

        /**
         * 规格值
         */
        private String value;

        /**
         * 创建时间
         */
        private LocalDateTime createTime;

        /**
         * 更新时间
         */
        private LocalDateTime updateTime;
    }
}
