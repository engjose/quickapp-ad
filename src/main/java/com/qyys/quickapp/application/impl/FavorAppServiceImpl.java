package com.qyys.quickapp.application.impl;
import com.github.pagehelper.PageInfo;
import com.qyys.quickapp.application.FavorAppService;
import com.qyys.quickapp.common.constant.UserContext;
import com.qyys.quickapp.common.enums.SkuLikeEnum;
import com.qyys.quickapp.common.exception.BusinessException;
import com.qyys.quickapp.common.exception.ExceptionEnum;
import com.qyys.quickapp.pojo.po.SkuPO;
import com.qyys.quickapp.pojo.po.UserFavorPO;
import com.qyys.quickapp.pojo.request.PageQueryRequest;
import com.qyys.quickapp.pojo.response.PageQueryResponse;
import com.qyys.quickapp.pojo.vo.SkuFavorVO;
import com.qyys.quickapp.repository.IFavorRepository;
import com.qyys.quickapp.repository.ISkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Yuan.Pan 2022/4/17 10:46 AM
 */
@Service
public class FavorAppServiceImpl implements FavorAppService {

    @Autowired
    private IFavorRepository iFavorRepository;

    @Autowired
    private ISkuRepository iSkuRepository;

    @Override
    public void setSkuLike(Long skuId, Boolean likeFlag) {
        SkuPO skuPO = iSkuRepository.loadSku(skuId);
        if (null == skuPO) {
            throw new BusinessException(ExceptionEnum.SKU_IS_NULL);
        }

        UserFavorPO exist = iFavorRepository.loadSkuLike(UserContext.getUserId(), skuId);
        if (null == exist) {
            iFavorRepository.save(likeFlag, skuPO);
            return;
        }

        UserFavorPO record = new UserFavorPO();
        record.setId(exist.getId());
        record.setLikeFlag(SkuLikeEnum.ofEnum(likeFlag).getCode());
        record.setAddTime(new Date());
        iFavorRepository.updateSelective(record);
    }

    @Override
    public PageQueryResponse<SkuFavorVO> listSkuFavor(PageQueryRequest request) {
        PageInfo<UserFavorPO> pageInfo = iFavorRepository.pageSelect(UserContext.getUserId(), request);
        List<SkuFavorVO> resultList = pageInfo.getList().stream()
                .map(element -> {
                    SkuFavorVO record = new SkuFavorVO();
                    record.setSkuId(element.getSkuId());
                    record.setSkuName(element.getSkuName());
                    record.setSkuImg(element.getSkuImg());
                    return record;
                }).collect(Collectors.toList());

        return new PageQueryResponse<>(pageInfo.getTotal(), resultList);
    }
}
