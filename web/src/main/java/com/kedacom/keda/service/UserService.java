package com.kedacom.keda.service;

import com.kedacom.user.model.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 实习期考核项目
 * com.kedacom.keda.service
 * 2018-01-02-19:23
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-02.
 */
@FeignClient("user-service")
public interface UserService {

    @PostMapping("/user/login")
    User login(@RequestBody User user);

    @PostMapping("user/insertUser") Boolean register(@RequestBody User user);
}
