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
public class UserPO implements Serializable {
    /** 逻辑主键 */
    private Long id;

    /** userId */
    private String userId;

    /** 用户名 */
    private String userName;

    /** 用户密码 */
    private String password;

    /** 添加时间 */
    private Date addTime;

    /** 更新时间 */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}