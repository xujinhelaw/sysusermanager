package com.unity.authentication.manager.control;

import com.unity.authentication.manager.pojo.User;
import com.unity.authentication.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public void updateUserByName(@RequestBody User user){
        userService.updateUserByName(user);
    }
}
