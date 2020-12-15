package com.shiro.mapper;

import com.shiro.pojo.User;
import com.shiro.pojo.UserInfo;

import java.util.List;

public interface UserMapper
{
    List<User> findAllUser();

    void insertUser(User user);

    void insertUserInfo(UserInfo userinfo);

    void deleteUser(String userId);

    void deleteUserInfo(String userId);

    User findModulesOfCurrentUser(String username);

    User findUserByUsername(String loginUsername);
}
