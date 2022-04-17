package com.qyys.quickapp.interfaces.controller;
import com.qyys.quickapp.application.FavorAppService;
import com.qyys.quickapp.intergration.auth.LoginAuth;
import com.qyys.quickapp.pojo.request.PageQueryRequest;
import com.qyys.quickapp.pojo.request.UserFavorRequest;
import com.qyys.quickapp.pojo.response.BaseResponse;
import com.qyys.quickapp.pojo.response.PageQueryResponse;
import com.qyys.quickapp.pojo.vo.SkuFavorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Yuan.Pan 2022/4/16 10:44 PM
 */
@Validated
@RestController
@RequestMapping("/quick-app/favor")
public class FavorController {

    @Autowired
    private FavorAppService favorAppService;

    @LoginAuth
    @PostMapping("/setLike")
    public BaseResponse<Void> setSkuLike(@Validated @RequestBody UserFavorRequest request) {
        favorAppService.setSkuLike(request.getSkuId(), request.getLikeFlag());
        return BaseResponse.SUCCESS();
    }

    @LoginAuth
    @GetMapping("/list")
    public BaseResponse<PageQueryResponse<SkuFavorVO>> listSkuFavor(PageQueryRequest request) {
        return BaseResponse.SUCCESS(favorAppService.listSkuFavor(request));
    }
}
