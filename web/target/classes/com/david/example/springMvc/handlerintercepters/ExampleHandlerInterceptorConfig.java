package com.david.example.springMvc.handlerintercepters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version $Id: null.java, v 1.0 2019/8/29 11:27 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:$
 * @since 1.0
 **/
@Configuration
public class ExampleHandlerInterceptorConfig {

    @Bean
    public ExampleHandlerInterceptor exampleHandlerInterceptor(){
        return new ExampleHandlerInterceptor();
    }
}
