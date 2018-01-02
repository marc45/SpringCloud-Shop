package com.kedacom.keda.service;

import com.kedacom.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 实习期考核项目
 * com.kedacom.keda.service
 * 2018-01-02-19:23
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-02.
 */
@FeignClient("user-service")
public interface UserService {

    @GetMapping("/user/getByName/{name}")
    User getByName(String name);
}
