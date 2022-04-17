package com.qyys.quickapp.repository;

import com.qyys.quickapp.pojo.po.UserPO;

/**
 * @author : Yuan.Pan 2022/4/16 1:40 PM
 */
public interface IUserRepository {

    UserPO selectUser(String userName);

    UserPO save(String userName, String password);
}
