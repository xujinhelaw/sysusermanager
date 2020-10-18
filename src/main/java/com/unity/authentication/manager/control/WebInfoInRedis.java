package com.unity.authentication.manager.control;

import com.unity.authentication.manager.pojo.WebInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by xuhelaw on 2020/10/18.
 */
@RestController
public class WebInfoInRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/setWebInfo",method = RequestMethod.POST)
    public void setWebInfoInRedis(@RequestBody WebInfo webInfo){
        redisTemplate.opsForValue().set("webInfo",webInfo);

    }

    @RequestMapping("/getWebInfo")
    @ResponseBody
    public String getWebInfoInRedis(){
       return redisTemplate.opsForValue().get("webInfo").toString();

    }
}
