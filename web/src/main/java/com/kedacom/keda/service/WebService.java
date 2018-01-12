package com.kedacom.keda.service;

import com.kedacom.category.model.Category;
import com.kedacom.user.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
