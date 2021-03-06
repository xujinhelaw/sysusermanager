package com.unity.authentication.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by xuhelaw on 2020/10/17.
 */
@SpringBootApplication
@MapperScan("com.unity.authentication.manager.dao")
public class SysUserManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysUserManagerApplication.class, args);
    }
}
