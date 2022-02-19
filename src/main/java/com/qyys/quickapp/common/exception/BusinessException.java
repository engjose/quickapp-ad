package com.qyys.quickapp.common.exception;

/**
 * @author : Yuan.Pan 2020/6/15 5:53 PM
 */
public class BusinessException extends RuntimeException {

    private String code;
    private String message;

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(ExceptionEnum ex) {
        super(ex.getMessage());
        this.code = ex.getCode();
        this.message = ex.getMessage();
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public BusinessException(String code, String message, Object... bundle) {
        super((null != bundle && bundle.length > 0) ? String.format(message, bundle) : message);
        this.code = code;
        this.message = (null != bundle && bundle.length > 0) ? String.format(message, bundle) : message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
