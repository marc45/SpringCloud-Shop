package com.kedacom.keda.service;

import com.kedacom.commons.vo.OrderVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 实习期考核项目
 * com.kedacom.consumer
 * 2018-01-02-19:05
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-02.
 */
@FeignClient("order-service")
public interface OrderService {

    @PostMapping("/order/addOrder") boolean addOrder(@RequestBody OrderVo orderVo);

}
