package com.kedacom.category.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 实习期考核项目
 * com.kedacom.goods.model
 * 2017-12-28-15:29
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
@Entity
public class Category implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分类层级，从0开始
     */
    private Integer level;

    @Column(name = "parent_id") private Long parentId; // childs建立映射时默认使用的是主键id，而主键是Long，对应bigint，parentId如果是String则对应VARCHAR(255)，两个类型不一样，因此无法建立外键约束成功

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST) @JoinColumn(name = "parent_id") @OrderBy(value = "order_number ASC") private List<Category> childs;

    /**
     * 分类名字
     */
    @NotNull @Size(min = 2, max = 20) private String name;

    /**
     * 排序数字
     */
    @Column(name = "order_number") private Long orderNumber;

    /**
     * 价格
     */
    @Column(name = "price")
    private BigDecimal price;

    /**
     * 图片
     */
    @Column(name = "img")
    private String img;

    /**
     * 详情
     */
    @Column(name = "detail")
    private String detail;

    public Category() {
    }

    public Category(Integer level, Long parentId, List<Category> childs, String name, Long orderNumber,
            BigDecimal price, String img, String detail) {
        this.level = level;
        this.parentId = parentId;
        this.childs = childs;
        this.name = name;
        this.orderNumber = orderNumber;
        this.price = price;
        this.img = img;
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<Category> getChilds() {
        return childs;
    }

    public void setChilds(List<Category> childs) {
        this.childs = childs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override public String toString() {
        return "Category{" + "id=" + id + ", level=" + level + ", parentId=" + parentId + ", childs=" + childs
                + ", name='" + name + '\'' + ", orderNumber=" + orderNumber + ", price=" + price + ", img='" + img
                + '\'' + ", detail='" + detail + '\'' + '}';
    }
}
