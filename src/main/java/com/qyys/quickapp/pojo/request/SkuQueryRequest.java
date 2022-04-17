package com.qyys.quickapp.pojo.request;
import lombok.Data;

/**
 * @author : Yuan.Pan 2022/4/16 4:10 PM
 */
@Data
public class SkuQueryRequest extends PageQueryRequest {

    /** 根据菜单id搜索 */
    private Long menuId;

    /** 根据skuName模糊搜索 */
    private String skuNameLike;
}
