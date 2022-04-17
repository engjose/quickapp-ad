package com.qyys.quickapp.repository;

import com.qyys.quickapp.pojo.po.UserLoginPO;

/**
 * @author : Yuan.Pan 2022/4/16 1:41 PM
 */
public interface IUserLoginRepository {

    void delete(String userId);

    String login(String userId);

    UserLoginPO selectByToken(String xToken);
}
