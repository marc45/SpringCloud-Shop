package com.kedacom.order;

import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/order")
    public String index(){
        return "订单服务";
    }
}

