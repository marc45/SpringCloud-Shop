package com.kedacom.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 实习期考核项目
 * com.kedacom.consumer
 * 2017-12-28-11:20
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
//Spring Cloud Feign
@FeignClient("eureka-client")//指定这个接口所要调用的服务名称(声明我们需要依赖的微服务接口)
public interface DcClient {
    @GetMapping("/dc")
    String consumer();
}
