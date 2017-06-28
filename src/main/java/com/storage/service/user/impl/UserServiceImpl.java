package com.storage.service.user.impl;

import com.storage.dao.user.IUserDao;
import com.storage.domain.User;
import com.storage.service.user.IUserService;
import com.storage.util.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

/**
 * Created by hs on 2017/6/27.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;

    @Override
    public User login(String email, String password) {
        User user = userDao.getUser(email);
        if (user == null) {
            return null;
        }
        String hashPassword = "";
        // 加密验证
        try {
            hashPassword = Encrypt.getSHA256(password + user.getSalt());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        return userDao.getUser(email, hashPassword);
    }

    @Override
    public boolean register(User user) {
        user.setCreateTime(new Date());
        // 生成6位随机salt
        Random random = new Random();
        int saltInt = random.nextInt((999999 - 100000) + 1) + 1000000;
        user.setSalt(String.valueOf(saltInt));
        // 加密密码
        try {
            user.setPassword(Encrypt.getSHA256(user.getPassword() + user.getSalt()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
        return userDao.addUser(user) > 0;
    }

    @Override
    public boolean checkEmailExist(String email) {
        return userDao.getUser(email) != null;
    }
}
