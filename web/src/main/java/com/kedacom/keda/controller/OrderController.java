package com.kedacom.keda.controller;

import com.kedacom.keda.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实习期考核项目
 * com.kedacom.consumer
 * 2018-01-02-19:06
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-02.
 */
@RestController
public class OrderController {

    @Autowired OrderService orderService;

    @GetMapping("/addOrder")
    public String addOrder() {
        return orderService.addOrder();
    }

}
