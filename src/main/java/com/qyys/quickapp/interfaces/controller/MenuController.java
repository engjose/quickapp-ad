package com.qyys.quickapp.interfaces.controller;
import com.qyys.quickapp.application.MenuAppService;
import com.qyys.quickapp.pojo.response.BaseResponse;
import com.qyys.quickapp.pojo.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author : Yuan.Pan 2022/4/16 3:49 PM
 */
@RestController
@RequestMapping("/quick-app/menu")
public class MenuController {

    @Autowired
    private MenuAppService menuAppService;

    @GetMapping("/list")
    public BaseResponse<List<MenuVO>> queryMenuList() {
        return BaseResponse.SUCCESS(menuAppService.queryMenuList());
    }
}
