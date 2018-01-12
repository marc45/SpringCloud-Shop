package com.kedacom.user;

import com.kedacom.user.model.User;
import com.kedacom.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	@Transactional
	public void test() throws Exception {
		//测试 事务
		// 创建10条记录
		userRepository.save(new User("AAA", "123456"));
		userRepository.save(new User("BBB", "123456"));
		userRepository.save(new User("CCC", "123456"));
		userRepository.save(new User("DDD", "123456"));
		userRepository.save(new User("EEE", "123456"));
		userRepository.save(new User("FFF", "123456"));
		userRepository.save(new User("GGG", "123456"));
		//name不能为空，会抛出异常，来测试事务是否会回滚
		userRepository.save(new User("测试测试测试测试测试测试", "123456"));
		userRepository.save(new User("III", "123456"));
		userRepository.save(new User("JJJ", "123456"));

		// 测试成功
	}


}
