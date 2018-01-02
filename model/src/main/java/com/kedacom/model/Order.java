package com.kedacom.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实习期考核项目
 * com.kedacom.model
 * 2018-01-02-13:35
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-02.
 */
@Entity
public class Order implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datetime")
    private Date datetime;

    @Column(name = "summoney")
    private BigDecimal summoney;

    @Column(name = "state")
    private int state;

    public Order() {
    }

    public Order(Date datetime, BigDecimal summoney, int state) {
        this.datetime = datetime;
        this.summoney = summoney;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public BigDecimal getSummoney() {
        return summoney;
    }

    public void setSummoney(BigDecimal summoney) {
        this.summoney = summoney;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override public String toString() {
        return "Order{" + "id=" + id + ", datetime=" + datetime + ", summoney=" + summoney + ", state=" + state + '}';
    }
}
