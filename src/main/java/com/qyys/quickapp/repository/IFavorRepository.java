package com.qyys.quickapp.repository;

import com.github.pagehelper.PageInfo;
import com.qyys.quickapp.pojo.po.SkuPO;
import com.qyys.quickapp.pojo.po.UserFavorPO;
import com.qyys.quickapp.pojo.request.PageQueryRequest;

/**
 * @author : Yuan.Pan 2022/4/17 10:49 AM
 */
public interface IFavorRepository {
    void updateSelective(UserFavorPO record);

    UserFavorPO loadSkuLike(String userId, Long skuId);

    void save(Boolean likeFlag, SkuPO skuPO);

    PageInfo<UserFavorPO> pageSelect(String userId, PageQueryRequest request);
}
