package com.kedacom.keda.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 实习期考核项目
 * com.kedacom.keda.config
 * 2017-12-28-14:18
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
/**
 * @Author:suxiongwei
 * @Description:配置
 * @Date:14:18 2017-12-28
 */
@Configuration
public class RootConfig {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
