package com.mall.goods.common.exception;

import com.mall.goods.common.enums.Resp;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {
    private Resp resp;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Resp resp) {
        super(resp.getMessage());
        this.resp = resp;
    }
}
