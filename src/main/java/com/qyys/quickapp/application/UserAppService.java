package com.qyys.quickapp.application;

/**
 * @author : Yuan.Pan 2022/4/16 3:50 PM
 */
public interface UserAppService {
    
    String register(String userName, String password);

    String login(String userName, String password);

    String authLogin(String xToken, Boolean required);
}
