package com.kedacom.keda.controller;

import com.kedacom.category.model.Category;
import com.kedacom.keda.service.CategoryService;
import com.kedacom.keda.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 实习期考核项目
 * com.kedacom.keda.controller
 * 2018-01-02-11:46
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-02.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired CategoryService categoryService;

    @GetMapping("/introduction/{id}")
    public String home(Map<String, Object> model,@PathVariable long id) {
        Category category = categoryService.getCategory(id);

        model.put("category", category);

        return "introduction";
    }
}
