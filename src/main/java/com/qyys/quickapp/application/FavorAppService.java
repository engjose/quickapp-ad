package com.qyys.quickapp.application;
import com.qyys.quickapp.pojo.request.PageQueryRequest;
import com.qyys.quickapp.pojo.response.PageQueryResponse;
import com.qyys.quickapp.pojo.vo.SkuFavorVO;

/**
 * @author : Yuan.Pan 2022/4/17 10:46 AM
 */
public interface FavorAppService {

    void setSkuLike(Long skuId, Boolean likeFlag);

    PageQueryResponse<SkuFavorVO> listSkuFavor(PageQueryRequest request);
}
