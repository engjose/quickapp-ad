package com.qyys.quickapp.application;
import com.qyys.quickapp.pojo.request.SkuQueryRequest;
import com.qyys.quickapp.pojo.response.PageQueryResponse;
import com.qyys.quickapp.pojo.vo.SkuVO;

/**
 * @author : Yuan.Pan 2022/4/16 3:51 PM
 */
public interface SkuAppService {

    PageQueryResponse<SkuVO> querySkuList(SkuQueryRequest request);

    SkuVO loadSku(Long skuId);
}
