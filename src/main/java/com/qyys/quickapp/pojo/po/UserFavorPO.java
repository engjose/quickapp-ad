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
 * @date 2022-04-17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFavorPO implements Serializable {
    /** 逻辑主键 */
    private Long id;

    /** 用户id */
    private String userId;

    /** skuId */
    private Long skuId;

    /** 商品名称 */
    private String skuName;

    /** 商品图片 */
    private String skuImg;

    /** 喜欢标志位 */
    private Integer likeFlag;

    /** 添加时间 */
    private Date addTime;

    private static final long serialVersionUID = 1L;
}