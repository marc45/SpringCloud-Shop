package com.kedacom.commons.vo;

import java.math.BigDecimal;

/**
 * 实习期考核项目
 * com.kedacom.commons.vo
 * 2018-01-03-14:08
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-03.
 */
public class OrderVo {
    private BigDecimal summoney;

    private Long categoryId;

    private Long userId;

    public OrderVo(BigDecimal summoney, Long categoryId, Long userId) {
        this.summoney = summoney;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public OrderVo() {
    }

    public BigDecimal getSummoney() {
        return summoney;
    }

    public void setSummoney(BigDecimal summoney) {
        this.summoney = summoney;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override public String toString() {
        return "OrderVo{" + "summoney=" + summoney + ", categoryId=" + categoryId + ", userId=" + userId + '}';
    }
}
