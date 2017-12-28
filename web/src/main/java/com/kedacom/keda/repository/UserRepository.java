package com.kedacom.keda.repository;

import com.kedacom.keda.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 实习期考核项目
 * com.kedacom.keda.repository
 * 2017-12-26-9:41
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-26.
 */

//1、User的ID类型为Long，继承了18个持久化操作的通用方法，应用启动的时候生成对应接口的实现类（添加了Impl后缀）
    //如果这个类存在的话，Spring Data JPA将会把它的方法与Spring Data JPA所生成的方法合并到一起
//2、在创建Repository的时候，Spring Data会检查Repository接口的所有方法，解析方法的名称，
// 并基于被持久化得对象来推测方法的目的
public interface UserRepository extends JpaRepository<User,Long> {

    //Repository方法组成 动词+主题+By+断言
    User findByName(String name);

    User findByNameAndAge(String name, int age);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
}
