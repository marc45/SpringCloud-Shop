package com.kedacom.keda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * 销售管理系统
 * com.kedacom.keda.config
 * 2018-01-11-14:01
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-11.
 */
@Configuration
public class CookieConfig {
//    @Bean
//    public CookieSerializer cookieSerializer() {
//        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
//        serializer.setCookieName("JSESSIONID");
//        serializer.setCookiePath("/");
//        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
//        return serializer;
//    }
}
