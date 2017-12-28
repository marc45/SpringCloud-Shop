package com.kedacom.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 实习期考核项目
 * com.kedacom.consumer
 * 2017-12-28-11:17
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
public class ConsumerController {
    @Autowired
    private DiscoveryClient discoveryClient;

    //服务发现
    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public String doDiscoveryService() {

        StringBuilder buf = new StringBuilder();

        List<String> serviceIds = discoveryClient.getServices();

        if(!CollectionUtils.isEmpty(serviceIds)) {
            for (String s : serviceIds) {
                System.out.println("serviceId:" + s);
                List<ServiceInstance> serviceInstances = discoveryClient.getInstances(s);
                if (!CollectionUtils.isEmpty(serviceInstances)) {
                    for (ServiceInstance si : serviceInstances) {
                        buf.append("[" + si.getServiceId() + " host=" + si.getHost() + " port=" + si.getPort() + " uri="
                                + si.getUri() + "]");
                    }
                } else {
                    buf.append("no service.");
                }
            }
        }
        return buf.toString();
    }
}
