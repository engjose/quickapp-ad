package com.qyys.quickapp.repository.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qyys.quickapp.pojo.po.SkuPO;
import com.qyys.quickapp.pojo.request.SkuQueryRequest;
import com.qyys.quickapp.repository.ISkuRepository;
import com.qyys.quickapp.repository.condition.SkuQueryCondition;
import com.qyys.quickapp.repository.mapper.SkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author : Yuan.Pan 2022/4/16 1:40 PM
 */
@Repository
public class SkuRepository implements ISkuRepository {

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public PageInfo<SkuPO> pageSelect(SkuQueryRequest request) {
        SkuQueryCondition condition = new SkuQueryCondition();
        condition.setMenuId(request.getMenuId());
        condition.setSkuNameLike(request.getSkuNameLike());

        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        return new PageInfo<>(skuMapper.selectList(condition));
    }

    @Override
    public SkuPO loadSku(Long skuId) {
        return skuMapper.selectByPrimaryKey(skuId);
    }

    @Override
    public List<SkuPO> selectSkuList(List<Long> skuIdList) {
        if (CollectionUtils.isEmpty(skuIdList)) {
            return Collections.emptyList();
        }

        SkuQueryCondition condition = new SkuQueryCondition();
        condition.setSkuIdList(skuIdList);
        return skuMapper.selectList(condition);
    }
}
