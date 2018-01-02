package com.kedacom.user.repository;

import com.kedacom.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 实习期考核项目
 * com.kedacom.user.repository
 * 2017-12-29-13:09
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-29.
 */
public interface UserRepository extends JpaRepository<User,Long>{
    User findByName(String name);


}
