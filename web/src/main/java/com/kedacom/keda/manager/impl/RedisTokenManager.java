package com.kedacom.keda.manager.impl;

import com.kedacom.keda.config.Constants;
import com.kedacom.keda.manager.TokenManager;
import com.kedacom.keda.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 实习考核项目
 * com.kedacom.apigateway.manager.impl
 * 2018-01-18-13:28
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-18.
 */
@Component
public class RedisTokenManager implements TokenManager {

    private RedisTemplate<Long, String> redis;

    @Autowired
    public void setRedis (@Qualifier("stringRedisTemplate") RedisTemplate redis) {
        this.redis = redis;
        // 泛型设置成 Long 后必须更改对应的序列 化方案
        redis.setKeySerializer (new JdkSerializationRedisSerializer());
    }

    public TokenModel createToken (long userId) {
        // 使用 uuid 作为源 token
        String token = UUID.randomUUID ().toString ().replace ("-", "");
        TokenModel model = new TokenModel (userId, token);
        // 存储到 redis 并设置过期时间
        redis.boundValueOps (userId).set (token, Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return model;
    }

    public TokenModel getToken (String authentication) {
        if (authentication == null || authentication.length () == 0) {
            return null;
        }
        String [] param = authentication.split ("_");
        if (param.length != 2) {
            return null;
        }
        // 使用 userId 和源 token 简单拼接成的 token，可以增加加密措施
        long userId = Long.parseLong (param [0]);
        String token = param [1];
        return new TokenModel (userId, token);
    }

    public boolean checkToken (TokenModel model) {
        if (model == null) {
            return false;
        }
        String token =redis.boundValueOps (model.getUserId ()).get ();
        if (token == null || !token.equals (model.getToken ())) {
            return false;
        }
        // 如果验证成功，说明此用户进行了一次有效操作，延长 token 的过期时间
        redis.boundValueOps (model.getUserId ()).expire (Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return true;
    }

    public void deleteToken (long userId) {
        redis.delete (userId);
    }
}
