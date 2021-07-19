package com.kedacom.user.repository;

import com.kedacom.user.model.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 实习期考核项目
 * com.kedacom.user.repository
 * 2017-12-29-13:09
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-29.
 */
@CacheConfig(cacheNames = "users")
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    @Cacheable(key = "#p0")
    User findByName(String name);

    @CachePut(key = "#p0.name")
    User save(User user);
}
