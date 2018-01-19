package com.kedacom.user;

import com.kedacom.user.model.User;
import com.kedacom.user.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 实习考核项目
 * com.kedacom.user
 * 2018-01-19-13:18
 * 2018科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2018-01-19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCacheTests {
    @Autowired
    private UserRepository userRepository;

    @Before
    public void before() {
        userRepository.save(new User("AAA","123456","18361246696"));
    }

    @Test
    public void test() throws Exception {
        User u1 = userRepository.findByName("AAA");
        System.out.println("第一次查询：" +u1.getPhone());

        User u2 = userRepository.findByName("AAA");
        System.out.println("第二次查询：" + u2.getPhone());
    }

}
