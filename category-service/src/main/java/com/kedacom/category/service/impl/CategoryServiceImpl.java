package com.kedacom.category.service.impl;

import com.kedacom.category.model.Category;
import com.kedacom.commons.api.ResourceNotFoundException;
import com.kedacom.category.repository.CategoryRepository;
import com.kedacom.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实习期考核项目
 * com.kedacom.goods.service.impl
 * 2017-12-28-14:57
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository goodRepository;

    @Override
    public Category findOne(Long id) {
        Category category = goodRepository.findOne(id);
        if (category == null)
            throw new ResourceNotFoundException(id);
        return category;
    }

    @Override
    public List<Category> findByLevelAndName(Integer level, String name) {
        return goodRepository.findByLevelAndName(level, name);
    }

    @Override
    public Category save(Category category) {
        return goodRepository.save(category);
    }
}
