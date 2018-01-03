package com.kedacom.order.service;

import com.kedacom.commons.vo.OrderVo;
import com.kedacom.model.Category;
import com.kedacom.order.model.Order;
import com.kedacom.order.model.OrderCategory;

import java.util.Locale;

/**
 * 实习期考核项目
 * com.kedacom.order.service
 * 2018-01-02-13:43
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-02.
 */
public interface OrderService {
    boolean save(OrderVo orderVo);
}
