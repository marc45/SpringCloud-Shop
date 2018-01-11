package com.kedacom.keda.config;

/**
 * 销售管理系统
 * com.kedacom.keda.config
 * 2018-01-11-10:43
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-11.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 开启spring session支持
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
    //Spring Session替换了默认的tomcat httpSession
}
