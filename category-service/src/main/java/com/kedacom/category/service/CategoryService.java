package com.kedacom.category.service;



import com.kedacom.category.model.Category;

import java.util.List;

/**
 * 实习期考核项目
 * com.kedacom.goods.service
 * 2017-12-28-14:56
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
public interface CategoryService {
    Category findOne(Long id);

    List<Category> findByLevelAndName(Integer level, String name);

    Category save(Category category);
}
