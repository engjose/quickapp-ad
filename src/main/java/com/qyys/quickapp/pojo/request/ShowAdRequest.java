package com.qyys.quickapp.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author : Yuan.Pan 2022/2/19 11:51 AM
 */
@Data
public class ShowAdRequest {

    @NotNull(message = "手机型号不能为空")
    private Integer phoneType;
}
