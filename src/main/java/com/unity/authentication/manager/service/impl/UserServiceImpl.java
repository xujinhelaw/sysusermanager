package com.unity.authentication.manager.service.impl;

import com.unity.authentication.manager.dao.UserMapper;
import com.unity.authentication.manager.pojo.User;
import com.unity.authentication.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuhelaw on 2020/10/18.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "user", key = "#name")
    public User queryUserByName(String name) {
        System.out.println("Get from database!");
        return userMapper.queryUserByName(name);
    }

    @CachePut(value = "user", key = "#user.name")
    public boolean updateUserByName(User user) {
        User userExist = userMapper.queryUserByName(user.getName());
        if (userExist == null) {
            return false;
        }
        return userMapper.updateUserByName(user);
    }

    public List<User> queryUsersByUserIds(String userIds) {
        return userMapper.queryUserByUserIds(userIds);
    }

}
