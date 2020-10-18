package com.unity.authentication.manager.control;

import com.unity.authentication.manager.pojo.User;
import com.unity.authentication.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuhelaw on 2020/10/18.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/{name}")
    public User queryUserByName(@PathVariable("name") String name) {
        return userService.queryUserByName(name);
    }
}
