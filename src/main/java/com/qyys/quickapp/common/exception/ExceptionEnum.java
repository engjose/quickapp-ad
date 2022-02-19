package com.qyys.quickapp.common.exception;
import lombok.Getter;

/**
 * @author : Yuan.Pan 2020/8/12 11:08 PM
 */
@Getter
public enum ExceptionEnum {
    SYSTEM_ERR("50000", "系统出小差了，请稍后重试"),
    PHONE_TYPE_NOT_SUPPORT("50001", "不支持的手机类型")
    ;

    private String code;
    private String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
