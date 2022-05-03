package com.qyys.quickapp.pojo.vo;

import lombok.Data;

/**
 * @author : Yuan.Pan 2022/4/16 3:54 PM
 */
@Data
public class MenuVO {

    /** 菜单ID */
    private Long menuId;

    /** 菜单名称 */
    private String menuName;

    /** 图片icon */
    private String defaultIcon;

    /** 选中ICON */
    private String selectIcon;
}
