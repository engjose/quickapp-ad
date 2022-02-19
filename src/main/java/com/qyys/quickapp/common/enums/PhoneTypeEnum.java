package com.qyys.quickapp.common.enums;

/**
 * @author : Yuan.Pan 2022/2/19 11:45 AM
 */
public enum PhoneTypeEnum {
    HUAWEI_PHONE(10, "华为机型"),
    XIAOMI_PHONE(20, "小米手机"),
    VIVO_PHONE(30, "vivo手机"),
    OPPO_PHONE(40, "OPPO手机");

    private int code;
    private String desc;

    PhoneTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static PhoneTypeEnum ofCode(int code) {
        for (PhoneTypeEnum element : PhoneTypeEnum.values()) {
            if (code == element.code) {
                return element;
            }
        }

        return null;
    }
}
