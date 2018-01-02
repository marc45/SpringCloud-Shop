package com.kedacom.order.service.impl;

import com.kedacom.order.model.Order;
import com.kedacom.order.repository.OrderRepository;
import com.kedacom.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实习期考核项目
 * com.kedacom.order.service.impl
 * 2018-01-02-13:44
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-02.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override public Order insertOrder(Order order) {
        return (Order) orderRepository.save(order);
    }
}
