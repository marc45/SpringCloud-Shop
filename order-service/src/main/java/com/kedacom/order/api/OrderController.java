package com.kedacom.order.api;

import com.kedacom.order.model.Order;
import com.kedacom.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实习期考核项目
 * com.kedacom.order
 * 2017-12-28-13:02
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired DiscoveryClient discoveryClient;

    @GetMapping("/addOrder")
    public String addOrder(){
        return "订单服务";
    }
}

