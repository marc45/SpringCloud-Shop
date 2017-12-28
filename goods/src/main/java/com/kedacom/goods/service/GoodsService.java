package com.kedacom.goods.service;

import com.kedacom.goods.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实习期考核项目
 * com.kedacom.goods.service
 * 2017-12-28-14:56
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
public interface GoodsService {
    Category findOne(Long id);

    List<Category> findByLevelAndName(Integer level, String name);

    Category save(Category category);
}
