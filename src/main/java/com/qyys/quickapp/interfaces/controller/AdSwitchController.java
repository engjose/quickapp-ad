package com.qyys.quickapp.interfaces.controller;
import com.qyys.quickapp.application.AdSwitchAppService;
import com.qyys.quickapp.pojo.vo.BaseResponse;
import com.qyys.quickapp.pojo.vo.SetAdConfRequest;
import com.qyys.quickapp.pojo.vo.ShowAdRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author : Yuan.Pan 2022/2/19 11:39 AM
 */
@RestController
@RequestMapping("/quick-app/conf")
public class AdSwitchController {

    @Resource
    private AdSwitchAppService adSwitchAppService;

    @PostMapping("/show-ad")
    public BaseResponse<Boolean> queryAdShow(@RequestBody @Validated ShowAdRequest request) {
        return BaseResponse.SUCCESS(adSwitchAppService.showAd(request.getPhoneType()));
    }

    @PostMapping("/set")
    public BaseResponse<Void> setAdConf(@RequestBody @Validated SetAdConfRequest request) {
        adSwitchAppService.setAdConf(request.getPhoneType(), request.getConfig());
        return BaseResponse.SUCCESS();
    }
}
