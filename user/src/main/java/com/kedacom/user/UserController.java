package com.kedacom.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实习期考核项目
 * com.kedacom.user
 * 2017-12-28-11:46
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
@RestController
public class UserController {
    @GetMapping("/user")
    public String index(){
        return "用户服务";
    }
}
