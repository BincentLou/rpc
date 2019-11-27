package com.david.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version $Id: null.java, v 1.0 2019/9/7 11:02 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:redis的控制器，当我们在配置文件中配置spring.redis之后，就会默认创建RedisTemplate
 * @since 1.0
 **/
@RestController
public class ExampleRedisController {

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @RequestMapping("/redis/value/{key}")
//    public String getRedisValue(@PathVariable String key){
//       return stringRedisTemplate.opsForValue().get(key);
//    }
//    @RequestMapping("/redis/set/{key}/{value}")
//    public Boolean setRedisValue(@PathVariable String key, @PathVariable String value){
//        stringRedisTemplate.opsForValue().set(key,value);
//        return true;
//    }
}
