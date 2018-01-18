package com.kedacom.keda.model;

/**
 * 实习考核项目
 * com.kedacom.apigateway.model
 * 2018-01-18-13:25
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-18.
 */
public class TokenModel {
    // 用户 id
    private long userId;
    // 随机生成的 uuid
    private String token;

    public TokenModel(long userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public long getUserId () {
        return userId;
    }

    public void setUserId (long userId) {
        this.userId = userId;
    }

    public String getToken () {
        return token;
    }

    public void setToken (String token) {
        this.token = token;
    }
}
