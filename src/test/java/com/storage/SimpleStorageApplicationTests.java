package com.storage;

import com.storage.config.DaoConfig;
import com.storage.dao.user.IUserDao;
import com.storage.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@Import(DaoConfig.class)
@SpringBootTest
public class SimpleStorageApplicationTests {

	@Autowired
	IUserDao userDao;

	@Test
	public void addUser() {
		User user = new User();
		user.setEmail("huangsenmx2@gmail.com");
		user.setPassword("123456");
		user.setSalt("password");
		user.setUserName("watson");
		user.setCreateTime(new Date());
		int result = userDao.addUser(user);
		Assert.assertTrue(result > 0);
	}

}
