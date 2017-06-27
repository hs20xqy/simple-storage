package com.storage.service.user;

import com.storage.domain.User;

/**
 * Created by hs on 2017/6/26.
 */
public interface IUserService {

    /**
     * 用户登录
     * @param email 邮箱
     * @param password 密码
     * @return
     */
    User login(String email, String password);

    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean register(User user);
}
