package com.kedacom.user.api;

import com.kedacom.commons.api.Result;
import com.kedacom.commons.util.ResultUtil;
import com.kedacom.user.model.User;
import com.kedacom.user.service.UserService;
import com.netflix.discovery.DiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 实习期考核项目
 * com.kedacom.user.api
 * 2017-12-29-13:09
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-29.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getByName/{name}",produces = "application/json")
    public User getUserByName(@PathVariable String name){
        User u = userService.findByName(name);
        return u;
    }
}
