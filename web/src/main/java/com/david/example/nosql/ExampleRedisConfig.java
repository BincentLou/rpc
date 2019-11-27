package com.david.example.nosql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version $Id: null.java, v 1.0 2019/9/7 11:03 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:当有spring-boot-starter-data-redis在classpath下的时候，会自动配置StringRedisTemplate 和RedisTemplate bean
 * 默认链接localhost:6379 本地服务，但是我们要开放到外网，就要更改application.properties配置
 * @since 1.0
 **/
@Configuration
public class ExampleRedisConfig {

//    private
}
