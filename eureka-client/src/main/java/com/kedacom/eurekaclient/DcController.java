package com.kedacom.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实习期考核项目
 * com.kedacom.eurekaclient
 * 2017-12-28-11:37
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
@RestController
public class DcController {

    @Autowired DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {
        String services = "eureka-client中的方法 "+"Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

}
