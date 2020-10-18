package com.unity.authentication.manager.handler.exception;

import com.unity.authentication.manager.SysUserManagerApplication;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by xuhelaw on 2020/10/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SysUserManagerApplication.class})
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void stringRedisTemplateTest(){
        stringRedisTemplate.opsForValue().set("site","www.sysusermanager.com");
    }
}
