package com.qyys.quickapp.application.impl;
import com.qyys.quickapp.application.MenuAppService;
import com.qyys.quickapp.pojo.po.MenuPO;
import com.qyys.quickapp.pojo.vo.MenuVO;
import com.qyys.quickapp.repository.IMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Yuan.Pan 2022/4/16 3:51 PM
 */
@Service
public class MenuAppServiceImpl implements MenuAppService {

    @Autowired
    private IMenuRepository iMenuRepository;

    @Override
    public List<MenuVO> queryMenuList() {
        List<MenuPO> list = iMenuRepository.selectList();
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }

        return list.stream()
                .map(element -> {
                    MenuVO menuVO = new MenuVO();
                    menuVO.setMenuId(element.getId());
                    menuVO.setMenuName(element.getMenuName());
                    menuVO.setDefaultIcon(element.getDefaultIcon());
                    menuVO.setSelectIcon(element.getSelectIcon());
                    return menuVO;
                }).collect(Collectors.toList());
    }
}
