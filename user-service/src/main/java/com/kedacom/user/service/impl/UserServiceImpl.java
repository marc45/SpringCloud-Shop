package com.kedacom.user.service.impl;

import com.kedacom.user.model.User;
import com.kedacom.user.repository.UserRepository;
import com.kedacom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实习期考核项目
 * com.kedacom.user.service.impl
 * 2017-12-29-13:12
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-29.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override public User save(User user) {
        return userRepository.save(user);
    }
}
