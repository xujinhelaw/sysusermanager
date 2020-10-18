package com.unity.authentication.manager.control;

import com.unity.authentication.manager.pojo.WebInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/setWebInfo",method = RequestMethod.POST)
    public void setWebInfoInRedis(@RequestBody WebInfo webInfo){
        stringRedisTemplate.opsForValue().set("site",webInfo.getSite());

    }

    @RequestMapping("/getWebInfo")
    @ResponseBody
    public String getWebInfoInRedis(){
       return stringRedisTemplate.opsForValue().get("site");

    }
}
