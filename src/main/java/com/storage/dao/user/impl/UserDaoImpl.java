package com.storage.dao.user.impl;

import com.storage.dao.user.IUserDao;
import com.storage.domain.User;
import com.storage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by hs on 2017/6/27.
 */
@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(String email, String password) {
        return userMapper.selectUserByEmailAndPassword(email, password);
    }

    @Override
    public int deleteUser(String userId) {
        return 0;
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }
}
