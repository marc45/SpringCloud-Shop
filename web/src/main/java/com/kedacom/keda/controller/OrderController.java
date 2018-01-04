package com.kedacom.keda.controller;

import com.kedacom.commons.vo.OrderVo;
import com.kedacom.keda.domain.Result;
import com.kedacom.keda.service.OrderService;
import com.kedacom.keda.utils.ResultUtil;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 实习期考核项目
 * com.kedacom.consumer
 * 2018-01-02-19:06
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-02.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired OrderService orderService;

    @PostMapping("/addOrder")
    public Result addOrder(OrderVo orderVo) {
        orderService.addOrder(orderVo);

        return ResultUtil.success();
    }

}
