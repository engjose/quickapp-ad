package com.qyys.quickapp.application;

/**
 * @author : Yuan.Pan 2022/2/19 12:07 PM
 */
public interface AdSwitchAppService {

    /**
     * deduce if show ad
     *
     * @param phoneType {@link com.qyys.quickapp.common.enums.PhoneTypeEnum}
     * @return TRUE:show ad; FALSE:hidden ad
     */
    Boolean showAd(Integer phoneType);

    /**
     * sey ad show config
     *
     * @param phoneType {@link com.qyys.quickapp.common.enums.PhoneTypeEnum}
     * @param config show config
     */
    void setAdConf(Integer phoneType, Boolean config);
}
