package com.qyys.quickapp.repository.mapper;

import com.qyys.quickapp.pojo.po.UserFavorPO;

import java.util.List;

/**
* Created by Mybatis Generator on 2022-04-17
*/
public interface UserFavorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserFavorPO record);

    int insertSelective(UserFavorPO record);

    UserFavorPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserFavorPO record);

    int updateByPrimaryKey(UserFavorPO record);

    UserFavorPO selectBySkuId(Long skuId);

    List<UserFavorPO> selectByUserId(String userId);
}