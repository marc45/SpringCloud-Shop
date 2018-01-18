package com.kedacom.keda.controller;

/**
 * 实习考核项目
 * com.kedacom.apigateway.controller
 * 2018-01-18-13:36
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-18.
 */

import com.kedacom.commons.api.Result;
import com.kedacom.commons.util.ResultUtil;
import com.kedacom.keda.annotation.Authorization;
import com.kedacom.keda.annotation.CurrentUser;
import com.kedacom.keda.manager.TokenManager;
import com.kedacom.keda.model.TokenModel;
import com.kedacom.keda.service.UserService;
import com.kedacom.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 基于ACCESS TOKEN的进行权限验证
 * 获取和删除 token 的请求地址，在 Restful 设计中其实就对应着登录和退出登录的资源映射
 */
@RestController
@RequestMapping("/tokens")
public class TokenController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenManager tokenManager;

    @PostMapping("/login")
    public Result login (User user) {
        Assert.notNull (user.getName(), "username can not be empty");
        Assert.notNull (user.getPassword(), "password can not be empty");


        User u = userService.login(user);
        if (u == null || !u.getPassword ().equals (user.getPassword())) { // 密码错误
            // 提示用户名或密码错误
            return ResultUtil.error(2,"用户名或密码有误");
        }
        // 生成一个 token，保存用户登录状态
        TokenModel model = tokenManager.createToken (u.getId ());
        return ResultUtil.success(model);
    }

    @RequestMapping (method = RequestMethod.DELETE)
    @Authorization
    public Result logout (@CurrentUser User user) {
        tokenManager.deleteToken (user.getId ());
        return ResultUtil.success();
    }

    /**
     * 测试
     */
    @RequestMapping("/test")
    public String test() {
        return "成功";
    }

}
