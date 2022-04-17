package com.qyys.quickapp.common.enums;

import com.qyys.quickapp.pojo.po.UserFavorPO;
import lombok.Getter;

/**
 * @author : Yuan.Pan 2022/4/17 11:04 AM
 */
@Getter
public enum SkuLikeEnum {
    COLLECTION(10, "收藏"),
    UN_COLLECTION(20, "未收藏");

    private int code;
    private String desc;

    SkuLikeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SkuLikeEnum ofEnum(Boolean likeFlag) {
        return (null != likeFlag && likeFlag) ? COLLECTION : UN_COLLECTION;
    }

    public static Boolean ofBoolean(UserFavorPO favor) {
        if (null == favor) {
            return false;
        }

        return COLLECTION.code == favor.getLikeFlag();
    }
}
