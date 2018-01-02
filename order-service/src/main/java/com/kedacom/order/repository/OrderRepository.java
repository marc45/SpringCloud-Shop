package com.kedacom.order.repository;

import com.kedacom.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 实习期考核项目
 * com.kedacom.order.repository
 * 2018-01-02-13:43
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-02.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
