package com.unity.authentication.manager.certificate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuhelaw on 2020/10/17.
 */
@RestController
public class Certificate {
    @Value("${cas.url}")
    private String casUrl;

    @RequestMapping(value = "/certificate")
    public String certificate() {
        return "certificate" + casUrl;
    }

}
