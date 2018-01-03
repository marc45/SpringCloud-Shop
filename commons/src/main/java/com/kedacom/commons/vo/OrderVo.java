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

    public OrderVo(BigDecimal summoney, Long categoryId) {
        this.summoney = summoney;
        this.categoryId = categoryId;
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

    @Override public String toString() {
        return "OrderVo{" + "summoney=" + summoney + ", categoryId=" + categoryId + '}';
    }
}
