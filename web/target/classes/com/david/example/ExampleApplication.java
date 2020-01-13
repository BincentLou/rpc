package com.david.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @version $Id: null.java, v 1.0 2019/8/21 1:49 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:$springApplicatin 启动类
 * @since 1.0
 **/
@SpringBootApplication(scanBasePackages = {"com.david.example"})
@MapperScan({"com.david.example.mapper"})
public class ExampleApplication {

    public static void main(String[] args){
        new SpringApplicationBuilder().bannerMode(Banner.Mode.LOG)
                .sources(ExampleApplication.class)
                .profiles("test")
                .run(args);
    }
}
