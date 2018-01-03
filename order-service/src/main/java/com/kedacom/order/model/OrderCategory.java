package com.kedacom.order.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 实习期考核项目
 * com.kedacom.model
 * 2018-01-03-13:41
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-03.
 */
@Entity
public class OrderCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "categoryId")
    private Long categoryId;

    @Column(name = "num")
    private int num;

    @Column(name = "createTime")
    private Date createTime;

    public OrderCategory() {
    }

    public OrderCategory(Long orderId, Long categoryId, int num, Date createTime) {
        this.orderId = orderId;
        this.categoryId = categoryId;
        this.num = num;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override public String toString() {
        return "OrderCategory{" + "id=" + id + ", orderId=" + orderId + ", categoryId=" + categoryId + ", num=" + num
                + ", createTime=" + createTime + '}';
    }
}
