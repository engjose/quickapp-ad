package com.qyys.quickapp.repository;

import com.qyys.quickapp.pojo.po.MenuPO;

import java.util.List;

/**
 * @author : Yuan.Pan 2022/4/16 1:38 PM
 */
public interface IMenuRepository {

    List<MenuPO> selectList();
}
