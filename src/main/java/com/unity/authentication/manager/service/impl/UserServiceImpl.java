package com.unity.authentication.manager.service.impl;

import com.unity.authentication.manager.dao.UserMapper;
import com.unity.authentication.manager.pojo.User;
import com.unity.authentication.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuhelaw on 2020/10/18.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}
