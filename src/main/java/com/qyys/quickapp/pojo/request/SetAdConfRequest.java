package com.qyys.quickapp.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author : Yuan.Pan 2022/2/19 12:29 PM
 */
@Data
public class SetAdConfRequest {

    @NotNull(message = "手机类型不能为空")
    private Integer phoneType;

    @NotNull(message = "配置信息不能为空")
    private Boolean config;
}
