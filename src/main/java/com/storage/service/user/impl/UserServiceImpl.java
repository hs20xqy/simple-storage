package com.storage.service.user.impl;

import com.storage.dao.user.IUserDao;
import com.storage.domain.User;
import com.storage.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by hs on 2017/6/27.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;

    @Override
    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }

    @Override
    public boolean register(User user) {
        user.setCreateTime(new Date());
        user.setSalt("");
        return userDao.addUser(user) > 0;
    }
}
