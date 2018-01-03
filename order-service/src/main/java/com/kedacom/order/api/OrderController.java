package com.kedacom.order.api;

import com.kedacom.commons.vo.OrderVo;
import com.kedacom.model.Category;
import com.kedacom.order.model.Order;
import com.kedacom.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * 实习期考核项目
 * com.kedacom.order
 * 2017-12-28-13:02
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired DiscoveryClient discoveryClient;

    @PostMapping("/addOrder")
    public Boolean addOrder(@RequestBody OrderVo orderVo){
        orderService.save(orderVo);
        return true;
    }
}

