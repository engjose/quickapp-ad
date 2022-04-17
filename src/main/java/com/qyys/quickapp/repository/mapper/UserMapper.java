package com.qyys.quickapp.repository.mapper;

import com.qyys.quickapp.pojo.po.UserPO;

/**
* Created by Mybatis Generator on 2022-04-16
*/
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserPO record);

    int insertSelective(UserPO record);

    UserPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);

    UserPO selectByUserName(String userName);
}