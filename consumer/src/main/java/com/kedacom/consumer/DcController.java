package com.kedacom.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 实习期考核项目
 * com.kedacom.consumer
 * 2017-12-28-11:21
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
@RestController
public class DcController {
    //负载均衡客户端的抽象定义
    @Autowired LoadBalancerClient loadBalancerClient;

    //调用http请求的WebService，并将结果转换成相应的对象类型
    @Autowired RestTemplate restTemplate;
    //1.0
    //    @GetMapping("/consumer")
    //    public String dc() {
    //        //负载均衡的选出一个eureka-client的服务实例
    //        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
    //        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
    //        System.out.println(url);
    //        return restTemplate.getForObject(url, String.class);
    //    }

    //2.0 Spring Cloud Ribbon

    //    @GetMapping("/consumer")
    //    public String dc() {
    //        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    //    }

    //3.0 Spring Cloud Feign 服务调用的方式更加简单
    @Autowired
    DcClient dcClient;

    @GetMapping("/consumer")
    public String dc() {
        return dcClient.consumer();
    }
}
