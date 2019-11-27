package com.david.example.endpoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/**
 * @version $Id: null.java, v 1.0 2019/9/25 10:56 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:自定义 endpoint
 * @since 1.0
 **/
@Configuration
public class ExampleEndPointConfiguration {

    public String customerEndPoint(){
        return "自定义的endpoint";
    }
}
