package com.qyys.quickapp.application.impl;

import com.qyys.quickapp.application.AdSwitchAppService;
import com.qyys.quickapp.common.enums.PhoneTypeEnum;
import com.qyys.quickapp.common.exception.BusinessException;
import com.qyys.quickapp.common.exception.ExceptionEnum;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Yuan.Pan 2022/2/19 12:07 PM
 */
@Service
public class AdSwitchAppServiceImpl implements AdSwitchAppService {

    private static Map<PhoneTypeEnum, Boolean> SHOW_AD_CACHE;

    static {
        SHOW_AD_CACHE = new HashMap<>();
        SHOW_AD_CACHE.put(PhoneTypeEnum.HUAWEI_PHONE, Boolean.TRUE);
        SHOW_AD_CACHE.put(PhoneTypeEnum.XIAOMI_PHONE, Boolean.TRUE);
        SHOW_AD_CACHE.put(PhoneTypeEnum.VIVO_PHONE, Boolean.TRUE);
        SHOW_AD_CACHE.put(PhoneTypeEnum.OPPO_PHONE, Boolean.TRUE);
    }

    @Override
    public Boolean showAd(Integer phoneType) {
        PhoneTypeEnum phoneTypeEnum = PhoneTypeEnum.ofCode(phoneType);
        if (null == phoneTypeEnum) {
            throw new BusinessException(ExceptionEnum.PHONE_TYPE_NOT_SUPPORT);
        }
        return SHOW_AD_CACHE.get(phoneTypeEnum);
    }

    @Override
    public void setAdConf(Integer phoneType, Boolean config) {
        PhoneTypeEnum phoneTypeEnum = PhoneTypeEnum.ofCode(phoneType);
        if (null == phoneTypeEnum) {
            throw new BusinessException(ExceptionEnum.PHONE_TYPE_NOT_SUPPORT);
        }
        SHOW_AD_CACHE.put(phoneTypeEnum, config);
    }
}
