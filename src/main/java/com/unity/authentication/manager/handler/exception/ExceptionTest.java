package com.unity.authentication.manager.handler.exception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuhelaw on 2020/10/18.
 */
@RestController
public class ExceptionTest {
    @RequestMapping("/exception")
    public void exception() throws UamException {
        throw new UamException("409","用户不存在");
    }
}
