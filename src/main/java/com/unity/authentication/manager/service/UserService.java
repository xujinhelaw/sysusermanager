package com.unity.authentication.manager.service;

import com.unity.authentication.manager.pojo.User;

/**
 * Created by xuhelaw on 2020/10/18.
 */
public interface UserService {
    User queryUserByName(String name);

    void updateUserByName(User user);
}
