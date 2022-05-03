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
 * @date 2022-05-03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuPO implements Serializable {
    /** 自增主键 */
    private Long id;

    /** 菜单名称 */
    private String menuName;

    /** 图片icon */
    private String defaultIcon;

    /** 选中icon */
    private String selectIcon;

    /** 菜单顺序 */
    private Integer menuRank;

    /** 添加时间 */
    private Date addTime;

    /** 更新时间 */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}