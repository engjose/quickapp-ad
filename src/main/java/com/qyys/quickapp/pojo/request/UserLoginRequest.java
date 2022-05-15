package com.qyys.quickapp.pojo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author : Yuan.Pan 2022/4/16 10:52 PM
 */
@Data
public class UserLoginRequest {

    @NotBlank(message = "用户名不能为空")
    @Length(min = 3, max = 10, message = "用户名在3~6位中间")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 10, message = "密码在6~10位之间")
    private String password;
}
