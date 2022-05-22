package com.qyys.quickapp.application.impl;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.qyys.quickapp.application.SkuAppService;
import com.qyys.quickapp.common.constant.UserContext;
import com.qyys.quickapp.common.enums.SkuLikeEnum;
import com.qyys.quickapp.pojo.po.SkuPO;
import com.qyys.quickapp.pojo.po.UserFavorPO;
import com.qyys.quickapp.pojo.request.SkuQueryRequest;
import com.qyys.quickapp.pojo.response.PageQueryResponse;
import com.qyys.quickapp.pojo.vo.SkuDetailVO;
import com.qyys.quickapp.pojo.vo.SkuMaterialVO;
import com.qyys.quickapp.pojo.vo.SkuVO;
import com.qyys.quickapp.repository.IFavorRepository;
import com.qyys.quickapp.repository.ISkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Yuan.Pan 2022/4/16 3:52 PM
 */
@Service
public class SkuAppServiceImpl implements SkuAppService {

    @Autowired
    private ISkuRepository iSkuRepository;

    @Autowired
    private IFavorRepository iFavorRepository;

    @Override
    public PageQueryResponse<SkuVO> querySkuList(SkuQueryRequest request) {
        PageInfo<SkuPO> pageInfo = iSkuRepository.pageSelect(request);

        List<SkuVO> resultList = pageInfo.getList()
                .stream()
                .map(element -> {
                    SkuVO skuVO = new SkuVO();
                    skuVO.setSkuId(element.getId());
                    skuVO.setSkuName(element.getSkuName());
                    skuVO.setSkuDesc(element.getSkuDesc());
                    skuVO.setSkuImg(element.getSkuImg());
                    skuVO.setMenuId(element.getMenuId());
                    skuVO.setSkuScore(element.getSkuScore());
                    skuVO.setMaterialList(JSONArray.parseArray(element.getMaterial(), SkuMaterialVO.class));
                    skuVO.setDetailList(JSONArray.parseArray(element.getDetail(), SkuDetailVO.class));
                    return skuVO;
                }).collect(Collectors.toList());

        return new PageQueryResponse<>(pageInfo.getTotal(), resultList);
    }

    @Override
    public SkuVO loadSku(Long skuId) {
        if (null == skuId) {
            return null;
        }

        SkuPO exist = iSkuRepository.loadSku(skuId);
        if (null == exist) {
            return null;
        }

        UserFavorPO userFavorPO = iFavorRepository.loadSkuLike(UserContext.getUserId(), skuId);

        SkuVO skuVO = new SkuVO();
        skuVO.setSkuId(exist.getId());
        skuVO.setSkuName(exist.getSkuName());
        skuVO.setSkuDesc(exist.getSkuDesc());
        skuVO.setSkuImg(exist.getSkuImg());
        skuVO.setMenuId(exist.getMenuId());
        skuVO.setSkuScore(exist.getSkuScore());
        skuVO.setLikeFlag(SkuLikeEnum.ofBoolean(userFavorPO));
        skuVO.setMaterialList(JSONArray.parseArray(exist.getMaterial(), SkuMaterialVO.class));
        skuVO.setDetailList(JSONArray.parseArray(exist.getDetail(), SkuDetailVO.class));
        return skuVO;
    }
}
