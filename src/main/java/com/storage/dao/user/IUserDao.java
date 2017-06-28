package com.storage.dao.user;

import com.storage.domain.User;

/**
 * Created by hs on 2017/6/26.
 */
public interface IUserDao {
    /**
     * 获取User
     * @param email 邮箱
     * @param password 密码
     * @return
     */
    User getUser(String email, String password);

    /**
     * 获取User
     * @param email 邮箱
     * @return
     */
    User getUser(String email);

    /**
     * 删除User
     * @param userId 用户id
     * @return
     */
    int deleteUser(String userId);

    /**
     * 添加User
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 修改User
     * @param user
     * @return
     */
    int updateUser(User user);

}
