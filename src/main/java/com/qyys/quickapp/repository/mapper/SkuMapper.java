package com.qyys.quickapp.repository.mapper;
import com.qyys.quickapp.pojo.po.SkuPO;
import com.qyys.quickapp.repository.condition.SkuQueryCondition;

import java.util.List;

/**
* Created by Mybatis Generator on 2022-04-16
*/
public interface SkuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SkuPO record);

    int insertSelective(SkuPO record);

    SkuPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SkuPO record);

    int updateByPrimaryKey(SkuPO record);

    List<SkuPO> selectList(SkuQueryCondition condition);
}