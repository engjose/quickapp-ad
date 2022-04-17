package com.qyys.quickapp.interfaces.controller;
import com.qyys.quickapp.application.UserAppService;
import com.qyys.quickapp.pojo.request.UserLoginRequest;
import com.qyys.quickapp.pojo.request.UserRegisterRequest;
import com.qyys.quickapp.pojo.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Yuan.Pan 2022/4/16 3:49 PM
 */
@Validated
@RestController
@RequestMapping("/quick-app/user")
public class UserController {

    @Autowired
    private UserAppService userAppService;

    @PostMapping("/register")
    public BaseResponse<String> register(@Validated @RequestBody UserRegisterRequest request) {
        return BaseResponse.SUCCESS(userAppService.register(request.getUserName(), request.getPassword()));
    }

    @PostMapping("/login")
    public BaseResponse<String> login(@Validated @RequestBody UserLoginRequest request) {
        return BaseResponse.SUCCESS(userAppService.login(request.getUserName(), request.getPassword()));
    }
}
