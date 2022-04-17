package com.qyys.quickapp.repository.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qyys.quickapp.common.constant.UserContext;
import com.qyys.quickapp.common.enums.SkuLikeEnum;
import com.qyys.quickapp.pojo.po.SkuPO;
import com.qyys.quickapp.pojo.po.UserFavorPO;
import com.qyys.quickapp.pojo.request.PageQueryRequest;
import com.qyys.quickapp.repository.IFavorRepository;
import com.qyys.quickapp.repository.mapper.UserFavorMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author : Yuan.Pan 2022/4/17 10:50 AM
 */
@Repository
public class FavorRepository implements IFavorRepository {

    @Autowired
    private UserFavorMapper userFavorMapper;

    @Override
    public void updateSelective(UserFavorPO record) {
        userFavorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public UserFavorPO loadSkuLike(String userId, Long skuId) {
        if (StringUtils.isBlank(userId) || null == skuId) {
            return null;
        }

        return userFavorMapper.selectBySkuId(skuId);
    }

    @Override
    public void save(Boolean likeFlag, SkuPO skuPO) {
        UserFavorPO record = new UserFavorPO();
        record.setSkuId(skuPO.getId());
        record.setSkuName(skuPO.getSkuName());
        record.setSkuImg(skuPO.getSkuImg());
        record.setLikeFlag(SkuLikeEnum.ofEnum(likeFlag).getCode());
        record.setAddTime(new Date());
        record.setUserId(UserContext.getUserId());
    }

    @Override
    public PageInfo<UserFavorPO> pageSelect(String userId, PageQueryRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        return new PageInfo<>(userFavorMapper.selectByUserId(userId));
    }
}
