package com.qyys.quickapp.pojo.vo;
import lombok.Data;

import java.util.List;

/**
 * @author : Yuan.Pan 2022/4/16 4:15 PM
 */
@Data
public class SkuVO {

    /** 逻辑主键 */
    private Long skuId;

    /** 引用菜单id */
    private Long menuId;

    /** 菜品名称 */
    private String skuName;

    /** 菜品描述 */
    private String skuDesc;

    /** 商品分数 */
    private Integer skuScore;

    /** sku图片 */
    private String skuImg;

    /** 是否已收藏 */
    private Boolean likeFlag;

    /** 配料，JSONArray */
    private List<SkuMaterialVO> materialList;

    /** 详情，JSONArray */
    private List<SkuDetailVO> detailList;
}
