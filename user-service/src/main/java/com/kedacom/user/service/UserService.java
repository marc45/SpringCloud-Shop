package com.kedacom.user.service;

import com.kedacom.user.model.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * 实习期考核项目
 * com.kedacom.user.service
 * 2017-12-29-13:11
 * 2017科达科技股份有限公司-版权所有
 * Created by suxiongwei on 2017-12-29.
 */
@Transactional
public interface UserService {
    User findByName(String name);

    User save(User user);
}
