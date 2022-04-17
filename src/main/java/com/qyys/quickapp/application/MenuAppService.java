package com.qyys.quickapp.application;

import com.qyys.quickapp.pojo.vo.MenuVO;

import java.util.List;

/**
 * @author : Yuan.Pan 2022/4/16 3:51 PM
 */
public interface MenuAppService {

    /**
     * query dish menu list
     *
     * @return menu vo list
     */
    List<MenuVO> queryMenuList();
}
