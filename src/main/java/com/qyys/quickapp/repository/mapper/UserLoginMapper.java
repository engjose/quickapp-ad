package com.qyys.quickapp.repository.mapper;

import com.qyys.quickapp.pojo.po.UserLoginPO;

/**
* Created by Mybatis Generator on 2022-04-16
*/
public interface UserLoginMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserLoginPO record);

    int insertSelective(UserLoginPO record);

    UserLoginPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserLoginPO record);

    int updateByPrimaryKey(UserLoginPO record);

    void deleteByUserId(String userId);

    UserLoginPO selectByToken(String xToken);
}