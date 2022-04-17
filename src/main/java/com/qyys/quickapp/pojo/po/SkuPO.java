package com.qyys.quickapp.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Generator
 *
 * @date 2022-04-16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkuPO implements Serializable {
    /** 逻辑主键 */
    private Long id;

    /** 引用菜单id */
    private Long menuId;

    /** 菜品名称 */
    private String skuName;

    /** 商品分数 */
    private Integer skuScore;

    /** sku图片 */
    private String skuImg;

    /** sku描述 */
    private String skuDesc;

    /** 配料，JSONArray */
    private String material;

    /** 详情，JSONArray */
    private String detail;

    /** 添加时间 */
    private Date addTime;

    /** 更新时间 */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}