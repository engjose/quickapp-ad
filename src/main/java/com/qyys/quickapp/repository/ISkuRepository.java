package com.qyys.quickapp.repository;
import com.github.pagehelper.PageInfo;
import com.qyys.quickapp.pojo.po.SkuPO;
import com.qyys.quickapp.pojo.request.SkuQueryRequest;
import java.util.List;

/**
 * @author : Yuan.Pan 2022/4/16 1:40 PM
 */
public interface ISkuRepository {

    PageInfo<SkuPO> pageSelect(SkuQueryRequest request);

    SkuPO loadSku(Long skuId);

    List<SkuPO> selectSkuList(List<Long> skuIdList);
}
