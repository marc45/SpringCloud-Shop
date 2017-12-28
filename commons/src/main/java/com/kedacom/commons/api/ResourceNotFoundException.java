package com.kedacom.commons.api;

/**
 * 实习期考核项目
 * com.kedacom.commons.api
 * 2017-12-28-15:01
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
/**
 * @Author:suxiongwei
 * @Description:资源未找到异常
 * @Date:15:01 2017-12-28
 */
public class ResourceNotFoundException extends RuntimeException {

    private Long resourceId;

    public ResourceNotFoundException(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getResourceId() {
        return this.resourceId;
    }

}
