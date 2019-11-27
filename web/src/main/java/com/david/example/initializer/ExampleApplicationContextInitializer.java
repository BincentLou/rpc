package com.david.example.initializer;

import com.david.example.ExampleParentObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * @version $Id: null.java, v 1.0 2019/8/22 10:47 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:refresh application 的 configurableApplicationContext 之前个性化修改context
 * 比如 registry configproperty or active profiles
 * @since 1.0
 **/
@Order(2)
public class ExampleApplicationContextInitializer extends ExampleParentObj implements ApplicationContextInitializer {

    public ExampleApplicationContextInitializer() {
        printStack();

    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        printStack();
        System.out.println("---------自定义applicationContext，当前的context为{"+applicationContext.toString());
    }
}
