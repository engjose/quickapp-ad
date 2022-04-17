package com.qyys.quickapp.repository.impl;

import com.qyys.quickapp.pojo.po.MenuPO;
import com.qyys.quickapp.repository.IMenuRepository;
import com.qyys.quickapp.repository.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Yuan.Pan 2022/4/16 1:39 PM
 */
@Repository
public class MenuRepository implements IMenuRepository {

    @Autowired
    private MenuMapper menuMapper;

    public List<MenuPO> selectList() {
        return menuMapper.selectList();
    }
}
