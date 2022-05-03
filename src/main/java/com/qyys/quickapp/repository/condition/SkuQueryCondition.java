package com.qyys.quickapp.repository.condition;

import lombok.Data;

/**
 * @author : Yuan.Pan 2022/4/16 11:33 PM
 */
@Data
public class SkuQueryCondition {

    private Long id;

    private Long menuId;

    private String skuNameLike;
}
