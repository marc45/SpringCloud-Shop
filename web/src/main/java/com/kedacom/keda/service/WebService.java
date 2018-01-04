package com.kedacom.keda.service;

import com.kedacom.carouselservice.model.Carousel;
import com.kedacom.category.model.Category;
import com.kedacom.keda.domain.Result;
import com.kedacom.keda.utils.ResultUtil;
import com.kedacom.user.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 实习期考核项目
 * com.kedacom.keda.service
 * 2017-12-28-14:19
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-28.
 */
@Service
public class WebService {
    private final Logger logger = LoggerFactory.getLogger(WebService.class);

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getCategoryFallback")
    public Category getCategory(Long id) {
        //        System.out.println("getCategory");
        return restTemplate.getForEntity("http://CATEGORY-SERVICE/category/" + id, Category.class).getBody();
    }

    private Category getCategoryFallback(Long id) {
        // throw new ServiceUnAvailableException("CATEGORY-SERVICE");
        logger.error("CATEGORY-SERVICE unavailable");
        return new Category();
    }

    @HystrixCommand(fallbackMethod = "getCarousels")
    public List<Carousel> getCarousels(String usedFor) {
        return restTemplate.getForEntity("http://CAROUSEL-SERVICE/carousels?usedFor=" + usedFor, List.class).getBody();
    }

    private List<Carousel> getCarousels() {
        logger.error("CAROUSEL-SERVICE unavailable");
        return new ArrayList<>();
    }

    @HystrixCommand(fallbackMethod = "getByNameFallback")
    public User getByName(String name){
        return restTemplate.getForEntity("http://USER-SERVICE/user/getByName/" + name,User.class).getBody();
    }

    private User getByNameFallback(String name) {
        logger.error("CAROUSEL-SERVICE unavailable");
        return new User();
    }

    @HystrixCommand(fallbackMethod = "saveUserFallback")
    public User saveUser(User user){
        ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://USER-SERVICE/category", User.class, null);
        return responseEntity.getBody();
    }

    private User saveUserFallback(User user) {
        logger.error("insertUser unavailable");
        return new User();
    }

//    addOrder
}
