package com.david.example.controller;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version $Id: null.java, v 1.0 2019/8/25 10:54 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:profile 简单示例
 * @since 1.0
 **/
@RestController
@Profile("proA")
public class ExampleProfileController implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
@RequestMapping("/profiles")
    public String profiles(){
        return environment.getActiveProfiles().toString();
    }
}
