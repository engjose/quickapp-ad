package com.qyys.quickapp.common.exception;
import lombok.Getter;

/**
 * @author : Yuan.Pan 2020/8/12 11:08 PM
 */
@Getter
public enum ExceptionEnum {
    SYSTEM_ERR("50000", "系统出小差了，请稍后重试"),
    PHONE_TYPE_NOT_SUPPORT("50001", "不支持的手机类型"),
    USER_NAME_HAS_REGISTER("50002", "用户名已经被注册"),
    USER_IS_NOT_EXIST("50003", "用户不存在，请先注册"),
    USER_PASSWORD_ERR("50004", "登录密码错误"),
    NOT_LOGIN_ERR("50005", "请先登录"),
    LOGIN_INVALID("50006", "登录失效，请重新登录"),
    SKU_IS_NULL("50007", "商品信息错误")
    ;

    private String code;
    private String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
