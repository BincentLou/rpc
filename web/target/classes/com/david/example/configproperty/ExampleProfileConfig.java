package com.david.example.configproperty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @version $Id: null.java, v 1.0 2019/8/25 10:55 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Configuration
@Profile("proA")
public class ExampleProfileConfig {

    @Bean
    public  ProfileA profileA(){
        return new ProfileA();
    }

    public class ProfileA{

        private String name = "proA";
    }
}
