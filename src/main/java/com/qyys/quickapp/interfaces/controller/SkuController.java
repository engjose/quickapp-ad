package com.qyys.quickapp.interfaces.controller;
import com.qyys.quickapp.application.SkuAppService;
import com.qyys.quickapp.intergration.auth.LoginAuth;
import com.qyys.quickapp.pojo.request.SkuQueryRequest;
import com.qyys.quickapp.pojo.response.BaseResponse;
import com.qyys.quickapp.pojo.response.PageQueryResponse;
import com.qyys.quickapp.pojo.vo.SkuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotNull;

/**
 * @author : Yuan.Pan 2022/4/16 3:49 PM
 */
@Validated
@RestController
@RequestMapping("/quick-app/sku")
public class SkuController {

    @Autowired
    private SkuAppService skuAppService;

    @GetMapping("/list")
    public BaseResponse<PageQueryResponse<SkuVO>> querySkuList(SkuQueryRequest request) {
        return BaseResponse.SUCCESS(skuAppService.querySkuList(request));
    }

    @LoginAuth(required = false)
    @GetMapping("/query")
    public BaseResponse<SkuVO> loadSku(@NotNull(message = "skuId不能为空") Long skuId) {
        return BaseResponse.SUCCESS(skuAppService.loadSku(skuId));
    }
}
