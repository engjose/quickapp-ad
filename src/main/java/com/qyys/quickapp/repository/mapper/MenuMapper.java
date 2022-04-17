package com.qyys.quickapp.repository.mapper;

import com.qyys.quickapp.pojo.po.MenuPO;

import java.util.List;

/**
* Created by Mybatis Generator on 2022-04-16
*/
public interface MenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MenuPO record);

    int insertSelective(MenuPO record);

    MenuPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MenuPO record);

    int updateByPrimaryKey(MenuPO record);

    List<MenuPO> selectList();
}