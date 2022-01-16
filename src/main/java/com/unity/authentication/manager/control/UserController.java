package com.unity.authentication.manager.control;

import com.unity.authentication.manager.common.CommonResult;
import com.unity.authentication.manager.pojo.BatchReq;
import com.unity.authentication.manager.pojo.Login;
import com.unity.authentication.manager.pojo.User;
import com.unity.authentication.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public void updateUserByName(@RequestBody User user) {
        userService.updateUserByName(user);
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody Login login) {
        return CommonResult.success("admin");
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public List<User> queryUsersByUserIds(@RequestBody @Validated BatchReq batchReq){
        return userService.queryUsersByUserIds(batchReq.getUserIds());
    }
}
