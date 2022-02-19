package com.qyys.quickapp.common.advice;
import com.qyys.quickapp.common.exception.BusinessException;
import com.qyys.quickapp.common.exception.ExceptionEnum;
import com.qyys.quickapp.pojo.vo.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
/**
 * @author : Yuan.Pan 2022/2/19 12:22 PM
 */

@ControllerAdvice(basePackages = "com.qyys.quickapp.interfaces.controller")
public class ExceptionAdvice {

    private static final String PARAMS_ERR_CODE = "5000";
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public BaseResponse handlerBusinessException(BindException ex) {
        LOG.error("[BUSINESS-ERR e-{}]:", ex);
        return BaseResponse.FAIL(PARAMS_ERR_CODE, ex.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResponse handlerBusinessException(MethodArgumentNotValidException ex) {
        LOG.error("[BUSINESS-ERR e-{}]:", ex);
        return BaseResponse.FAIL(PARAMS_ERR_CODE, ex.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public BaseResponse handlerBusinessException(ConstraintViolationException ex) {
        LOG.error("[BUSINESS-ERR e-{}]:", ex);
        return BaseResponse.FAIL(PARAMS_ERR_CODE, ex.getConstraintViolations().iterator().next().getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public BaseResponse handlerBusinessException(BusinessException ex) {
        LOG.error("[BUSINESS-ERR e-{}]:", ex);
        return BaseResponse.FAIL(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public BaseResponse handlerThrowable(Throwable th) {
        LOG.error("error", th);
        return BaseResponse.FAIL(ExceptionEnum.SYSTEM_ERR.getCode(), ExceptionEnum.SYSTEM_ERR.getMessage());
    }
}
