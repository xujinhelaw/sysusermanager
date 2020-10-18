package com.unity.authentication.manager.certificate;

import com.unity.authentication.manager.handler.exception.UamException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuhelaw on 2020/10/17.
 */
@RestController
public class Certificate {
    @RequestMapping(value = "/certificate")
    public String certificate() {
        return "certificate";
    }
}
