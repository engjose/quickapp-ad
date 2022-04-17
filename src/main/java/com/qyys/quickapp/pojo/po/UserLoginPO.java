package com.qyys.quickapp.pojo.po;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class UserLoginPO implements Serializable {
    /** 逻辑主键 */
    private Long id;

    /** 用户id */
    private String userId;

    /** 登录凭证 */
    private String loginToken;

    /** 过期时间 */
    private Date expiredTime;

    /** 添加时间 */
    private Date addTime;

    private static final long serialVersionUID = 1L;
}