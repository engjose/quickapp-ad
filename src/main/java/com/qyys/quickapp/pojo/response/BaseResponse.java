package com.qyys.quickapp.pojo.response;

import lombok.Data;

/**
 * @author : Yuan.Pan 2020/8/12 10:43 PM
 */
@Data
public class BaseResponse<T> {

    private static String SUCCESS_CODE = "200";
    private static String SUCCESS_MESSAGE = "SUCCESS";

    private String code;
    private String message;
    private T data;

    private BaseResponse(T data, String code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public static <T> BaseResponse<T> SUCCESS() {
        return new BaseResponse<>(null, SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static <T> BaseResponse<T> SUCCESS(T data) {
        return new BaseResponse<>(data, SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static <T> BaseResponse<T> FAIL(String code, String message) {
        return new BaseResponse<>(null, code, message);
    }
}
