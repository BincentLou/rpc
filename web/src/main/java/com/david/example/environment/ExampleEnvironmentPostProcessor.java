package com.david.example.environment;

import com.david.example.ExampleParentObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @version $Id: null.java, v 1.0 2019/9/29 3:02 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: customize the environment before applicationContext refresh
 * @since 1.0
 **/
@Order(2)
public class ExampleEnvironmentPostProcessor extends ExampleParentObj implements EnvironmentPostProcessor {


    public ExampleEnvironmentPostProcessor() {
        printStack();
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        System.out.println("-----------------在环境配置完之后，你可以添加自己的配置，或者激活profile");
    }
}
