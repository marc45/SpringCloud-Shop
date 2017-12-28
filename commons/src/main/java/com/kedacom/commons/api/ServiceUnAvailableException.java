package com.kedacom.commons.api;

/**
 * 实习期考核项目
 * com.kedacom.commons.api
 * 2017-12-28-15:02
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
/**
 * @Author:suxiongwei
 * @Description:服务不可用异常
 * @Date:15:02 2017-12-28
 */
public class ServiceUnAvailableException extends RuntimeException {

    private String serviceId;

    public ServiceUnAvailableException(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceId() {
        return serviceId;
    }
}

