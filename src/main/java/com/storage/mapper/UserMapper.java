package com.storage.mapper;

import com.storage.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    User selectUserByEmail(String email);
}