package com.qyys.quickapp.pojo.request;
import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * @author : Yuan.Pan 2022/4/16 10:49 PM
 */
@Data
public class UserRegisterRequest {

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;
}
